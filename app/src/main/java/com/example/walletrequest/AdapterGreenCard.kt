package com.example.walletrequest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walletrequest.models.Card

class AdapterGreenCard(var models: List<Card>): RecyclerView.Adapter<ItemViewHolderGreenCard>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolderGreenCard {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_card_green, parent, false)
        return ItemViewHolderGreenCard(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: ItemViewHolderGreenCard, position: Int) {
        val dataVersion: Card = models[position]
        holder.configItem(dataVersion, position)
    }
}