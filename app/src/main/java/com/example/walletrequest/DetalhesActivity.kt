package com.example.walletrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.toDrawable
import com.example.walletrequest.configs.ConfRetrofit
import com.example.walletrequest.models.Card
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalhesActivity : AppCompatActivity() {
    private var configuracao = ConfRetrofit();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val btVoltar = findViewById<Button>(R.id.btVoltar)
        val idCard = intent.getStringExtra("ID").orEmpty()

        getByID(idCard)
        btVoltar.setOnClickListener() {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun getByID(id : String) {
        val service = configuracao.service
        service.getByID(id).enqueue(object: Callback<Card> {
            override fun onResponse(call: Call<Card>, response: Response<Card>) {
                val card: Card? = response.body()
                val tvCardType = findViewById<TextView>(R.id.tvCardType)
                val tvCardNome = findViewById<TextView>(R.id.tvCardNome)
                val tvCardNumber = findViewById<TextView>(R.id.tvCardNumber)
                val tvCardValidade = findViewById<TextView>(R.id.tvCardValidade)

                tvCardType.text = card?.cardType + " Card"
                tvCardNome.text = card?.name
                tvCardNumber.text = card?.number
                tvCardValidade.text = card?.expirationDate
            }

            override fun onFailure(call: Call<Card>, t: Throwable) {
                Toast.makeText(this@DetalhesActivity, t.message.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }
}