package com.example.walletrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var configuracao: ConfRetrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btOpenCad = findViewById<Button>(R.id.btOpenCad)

        btOpenCad.setOnClickListener() {
            val openCadastro = Intent(this, CadastroActivity::class.java).also {
                startActivity(it)
            }
        }

        /*
        configuracao = ConfRetrofit()

        val servico = configuracao.service

        servico.getAll().enqueue(object : Callback<List<Card>> {
            override fun onResponse(call: Call<List<Card>>, response: Response<List<Card>>) {
                //Toast.makeText(this, 1, Toast.LENGTH_LONG)
                Toast.makeText(this@MainActivity, "Sucesso", Toast.LENGTH_LONG).show();
            }

            override fun onFailure(call: Call<List<Card>>, t: Throwable) {
                println(t.message)
            }
        })
        */
    }
}