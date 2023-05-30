package com.example.walletrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.walletrequest.configs.ConfRetrofit
import com.example.walletrequest.models.Card
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalhesActivity2 : AppCompatActivity() {
    private var configuracao = ConfRetrofit();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes2)

        val btVoltar2 = findViewById<Button>(R.id.btVoltar2)
        val idCard2 = intent.getStringExtra("ID").orEmpty()

        getByID(idCard2)
        btVoltar2.setOnClickListener() {
            val openMainActivity = Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun getByID(id : String) {
        val service = configuracao.service
        service.getByID(id).enqueue(object: Callback<Card> {
            override fun onResponse(call: Call<Card>, response: Response<Card>) {
                val card2: Card? = response.body()
                val tvCardType2 = findViewById<TextView>(R.id.tvCardType2)
                val tvCardNome2 = findViewById<TextView>(R.id.tvCardNome2)
                val tvCardNumber2 = findViewById<TextView>(R.id.tvCardNumber2)
                val tvCardValidade2 = findViewById<TextView>(R.id.tvCardValidade2)

                tvCardType2.text = card2?.cardType
                tvCardNome2.text = card2?.name
                tvCardNumber2.text = card2?.number
                tvCardValidade2.text = card2?.expirationDate
            }

            override fun onFailure(call: Call<Card>, t: Throwable) {
                Toast.makeText(this@DetalhesActivity2, t.message.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }
}