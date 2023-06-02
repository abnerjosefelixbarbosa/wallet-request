package com.example.walletrequest

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.walletrequest.models.Card

class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private var clContainer: ConstraintLayout
    private var clCardLayout: ConstraintLayout
    private var tvCardTypeItem: TextView
    private var tvCardNomeItem: TextView
    private var tvCardNumberItem: TextView
    private var tvCardValidadeItem: TextView

    init {
        clContainer = itemView.findViewById(R.id.clConteinerCardItem)
        clCardLayout = itemView.findViewById(R.id.clCardItemLayout)
        tvCardTypeItem = itemView.findViewById(R.id.tvCardTypeItem)
        tvCardNomeItem = itemView.findViewById(R.id.tvCardNomeItem)
        tvCardNumberItem = itemView.findViewById(R.id.tvCardNumberItem)
        tvCardValidadeItem = itemView.findViewById(R.id.tvCardValidadeItem)
    }

    fun configItem(dataVersion: Card, position: Int) {
        tvCardNomeItem.text = dataVersion.name
        tvCardNumberItem.text = dataVersion.number
        tvCardValidadeItem.text = dataVersion.expirationDate
        if (dataVersion.cardType == "GREEN") {
            tvCardTypeItem.text = "Green Card"
            clCardLayout.setBackgroundResource(R.drawable.green_card)
        }
        if (dataVersion.cardType == "BLACK") {
            tvCardTypeItem.text = "Black Card"
            clCardLayout.setBackgroundResource(R.drawable.back_card)
        }
        clContainer.setOnClickListener() {
            Toast.makeText(itemView.context, "Cartão ${position + 1} escolhido", Toast.LENGTH_LONG).show()
        }
    }
}