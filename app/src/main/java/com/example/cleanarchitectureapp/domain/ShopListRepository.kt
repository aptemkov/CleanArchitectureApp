package com.example.cleanarchitectureapp.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(position: Int): ShopItem
    fun getShopList(): LiveData<List<ShopItem>>
}