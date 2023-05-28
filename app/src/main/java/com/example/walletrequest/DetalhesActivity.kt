package com.example.walletrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class DetalhesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val clCardLayout = findViewById<ConstraintLayout>(R.id.clCardLayout)
        val tvCardType = findViewById<TextView>(R.id.tvCardType)
        val tvCardNome = findViewById<TextView>(R.id.tvCardNome)
        val tvCardNumber = findViewById<TextView>(R.id.tvCardNumber)
        val tvCardValidade = findViewById<TextView>(R.id.tvCardValidade)
    }
}