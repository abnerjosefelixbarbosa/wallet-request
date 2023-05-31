package com.example.walletrequest

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.walletrequest.models.Card

class ItemViewHolderGreenCard(itemView: View): RecyclerView.ViewHolder(itemView) {
    private var clContainer: ConstraintLayout
    private var tvCardTypeListCardGreen: TextView
    private var tvCardNomeListCardGreen: TextView
    private var tvCardNumberListCardGreen: TextView
    private var tvCardValidadeListCardGreen: TextView

    init {
        clContainer = itemView.findViewById(R.id.clConteinerCardGreen)
        tvCardTypeListCardGreen = itemView.findViewById(R.id.tvCardTypeListCardGreen)
        tvCardNomeListCardGreen = itemView.findViewById(R.id.tvCardNomeListCardGreen)
        tvCardNumberListCardGreen = itemView.findViewById(R.id.tvCardNumberListCardGreen)
        tvCardValidadeListCardGreen = itemView.findViewById(R.id.tvCardValidadeListCardGreen)
    }

    fun configItem(dataVersion: Card, position: Int) {
        tvCardNomeListCardGreen.text = dataVersion.name
        tvCardNumberListCardGreen.text = dataVersion.number
        tvCardValidadeListCardGreen.text = dataVersion.expirationDate
        clContainer.setOnClickListener() {
            Toast.makeText(itemView.context, "Cartão escolhido", Toast.LENGTH_LONG).show()
        }
    }
}