package com.example.walletrequest

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.walletrequest.models.Card

class ItemViewHolderBlackCard(itemView: View): RecyclerView.ViewHolder(itemView) {
    private var clContainer: ConstraintLayout
    private var clCardLayout: ConstraintLayout
    private var tvCardTypeListCardBlack: TextView
    private var tvCardNomeListCardBlack: TextView
    private var tvCardNumberListCardBlack: TextView
    private var tvCardValidadeListCardBlack: TextView

    init {
        clContainer = itemView.findViewById(R.id.clConteinerCardBlack)
        clCardLayout = itemView.findViewById(R.id.clCardBackLayout)
        tvCardTypeListCardBlack = itemView.findViewById(R.id.tvCardTypeListCardBlack)
        tvCardNomeListCardBlack = itemView.findViewById(R.id.tvCardNomeListCardBlack)
        tvCardNumberListCardBlack = itemView.findViewById(R.id.tvCardNumberListCardBlack)
        tvCardValidadeListCardBlack = itemView.findViewById(R.id.tvCardValidadeListCardBlack)
    }

    fun configItem(dataVersion: Card, position: Int) {
        tvCardNomeListCardBlack.text = dataVersion.name
        tvCardNumberListCardBlack.text = dataVersion.number
        tvCardValidadeListCardBlack.text = dataVersion.expirationDate
        if (dataVersion.cardType == "GREEN") {
            tvCardTypeListCardBlack.text = "Green Card"
            clCardLayout.setBackgroundResource(R.drawable.green_card)
        }
        if (dataVersion.cardType == "BLACK") {
            tvCardTypeListCardBlack.text = "Black Card"
            clCardLayout.setBackgroundResource(R.drawable.back_card)
        }
        clContainer.setOnClickListener() {
            Toast.makeText(itemView.context, "Cartão ${position + 1} escolhido", Toast.LENGTH_LONG).show()
        }
    }
}