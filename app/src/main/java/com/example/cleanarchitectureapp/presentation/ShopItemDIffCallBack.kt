package com.example.cleanarchitectureapp.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.cleanarchitectureapp.domain.ShopItem

class ShopItemDIffCallBack: DiffUtil.ItemCallback<ShopItem>() {
    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem == newItem
    }
}