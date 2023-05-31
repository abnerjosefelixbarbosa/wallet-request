package com.example.walletrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.walletrequest.configs.ConfRetrofit
import com.example.walletrequest.exceptions.ValidException
import com.example.walletrequest.models.Card
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.lang.RuntimeException
import java.lang.reflect.InvocationTargetException
import java.util.UUID

class CadastroActivity : AppCompatActivity() {
    private var configuracao = ConfRetrofit();
    private var card: Card? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val edNumber = findViewById<EditText>(R.id.edNumber)
        val edName = findViewById<EditText>(R.id.edName)
        val edVencimento = findViewById<EditText>(R.id.edVencimento)
        val edCode = findViewById<EditText>(R.id.edCode)
        val btAvancar = findViewById<Button>(R.id.btAvanca)

        btAvancar.setOnClickListener() {
            try {
                val cardTypes = listOf<String>("BLACK","GREEN")
                val randomElement = cardTypes.randomOrNull()

                card = Card(
                    UUID.randomUUID().toString(),
                    edName.text.toString(),
                    edCode.text.toString(),
                    edNumber.text.toString(),
                    edVencimento.text.toString(),
                    randomElement.toString(),
                )

                validForm(card!!)
            } catch (e : ValidException) {
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            } catch (e : Exception) {
                e.printStackTrace()
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validForm(card: Card) {
        if (card.name.isEmpty())
           throw ValidException("nome esta vázio")
        if (card.cvv.length != 3)
            throw ValidException("cvv invalido")
        if (card.number.length != 19)
            throw ValidException("número invalido")
        if (card.expirationDate.length != 5)
            throw  ValidException("data invalida")
        val month = Integer.valueOf(card.expirationDate.subSequence(0,2).toString())
        if (month > 12)
            throw  ValidException("data invalida")
        if (card.cardType.isEmpty())
            throw  ValidException("tipo do carão vázio")
        getAll()
    }

    private fun getAll() {
        val service = configuracao.service
        service.getAll().enqueue(object : Callback<List<Card>> {
            override fun onResponse(call: Call<List<Card>>, response: Response<List<Card>>) {
                val list: List<Card>? = response.body()
                val listFilter = list!!.filter {
                    (it.number == card!!.number || it.cvv == card!!.cvv)
                }
                if (listFilter.isNotEmpty())
                    Toast.makeText(this@CadastroActivity, "número ou cvv existe", Toast.LENGTH_LONG).show()
                else
                    post(card!!)
            }

            override fun onFailure(call: Call<List<Card>>, t: Throwable) {
                Toast.makeText(this@CadastroActivity, t.message.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun post(card: Card) {
        val service = configuracao.service
        service.createCard(card).enqueue(object : Callback<Card> {
            override fun onResponse(call: Call<Card>, response: Response<Card>) {
                if (card.cardType == "BLACK") {
                    Intent(this@CadastroActivity, DetalhesActivity::class.java).also {
                        it.putExtra("ID", card.id)
                        startActivity(it)
                    }
                }
                if (card.cardType == "GREEN") {
                    Intent(this@CadastroActivity, DetalhesActivity2::class.java).also {
                        it.putExtra("ID", card.id)
                        startActivity(it)
                    }
                }
            }

            override fun onFailure(call: Call<Card>, t: Throwable) {
                Toast.makeText(this@CadastroActivity, t.message.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }
}
