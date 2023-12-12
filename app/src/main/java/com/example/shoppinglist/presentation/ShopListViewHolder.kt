package com.example.shoppinglist.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R

class ShopListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val textName = itemView.findViewById<TextView>(R.id.textViewName)
    val textCount = itemView.findViewById<TextView>(R.id.textViewCount)
}