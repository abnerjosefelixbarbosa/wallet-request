package com.example.walletrequest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walletrequest.models.Card

class Adapter(var models: List<Card>): RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_card, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val dataVersion: Card = models[position]
        holder.configItem(dataVersion, position)
    }
}