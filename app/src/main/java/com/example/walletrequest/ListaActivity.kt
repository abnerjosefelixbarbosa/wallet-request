package com.example.walletrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.walletrequest.configs.ConfRetrofit
import com.example.walletrequest.models.Card
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaActivity : AppCompatActivity() {
    private var configuracao = ConfRetrofit();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
        getAll()
    }

    private fun getAll() {
        val service = configuracao.service
        service.getAll().enqueue(object : Callback<List<Card>> {
            override fun onResponse(call: Call<List<Card>>, response: Response<List<Card>>) {
                val list: List<Card>? = response.body()
                filterList(list!!)
            }

            override fun onFailure(call: Call<List<Card>>, t: Throwable) {
                Toast.makeText(this@ListaActivity, t.message.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun filterList(list: List<Card>) {
        val recyclerBlackCard = findViewById<RecyclerView>(R.id.rvListVersion)
        recyclerBlackCard.adapter = Adapter(list)
    }
}