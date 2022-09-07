package com.example.cleanarchitectureapp.data

import com.example.cleanarchitectureapp.domain.ShopItem
import com.example.cleanarchitectureapp.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()

    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(position: Int): ShopItem {
        return shopList.find { it.id == position }
            ?: return ShopItem(name = "", count = 0, enabled = false)
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}