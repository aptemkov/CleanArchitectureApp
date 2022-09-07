package com.example.cleanarchitectureapp.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItem(position: Int): ShopItem {
        return shopListRepository.getShopItem(position)
    }
}