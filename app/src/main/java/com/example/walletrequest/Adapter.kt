package com.example.walletrequest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walletrequest.models.Card
import com.google.android.ads.mediationtestsuite.viewmodels.ItemViewHolder

class AdapterBlackCard(var models: List<Card>): RecyclerView.Adapter<ItemViewHolderBlackCard>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolderBlackCard {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_card_black, parent, false)
        return ItemViewHolderBlackCard(view)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: ItemViewHolderBlackCard, position: Int) {
        val dataVersion: Card = models[position]
        holder.configItem(dataVersion, position)
    }
}