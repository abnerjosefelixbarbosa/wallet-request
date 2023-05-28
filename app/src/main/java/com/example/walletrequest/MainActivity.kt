package com.example.walletrequest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.walletrequest.configs.ConfRetrofit

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
    }
}