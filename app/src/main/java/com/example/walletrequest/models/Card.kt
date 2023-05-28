package com.example.walletrequest

data class Card(
    val id: String,
    val name: String,
    val cvv: String,
    val number: String,
    val expirationDate: String,
    val cardType: String
)
