package com.example.walletrequest.configs

import com.example.walletrequest.services.ServiceCard
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfRetrofit {
    private val conguracao = Retrofit.Builder()
        .baseUrl("https://wallet-backend-theta.vercel.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = conguracao.create(ServiceCard::class.java)
}