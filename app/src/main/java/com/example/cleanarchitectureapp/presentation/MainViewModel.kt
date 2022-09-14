package com.example.cleanarchitectureapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
// Presentation слой не должен знать ничего из data слоя, потом исправлю
import com.example.cleanarchitectureapp.data.ShopListRepositoryImpl
import com.example.cleanarchitectureapp.domain.DeleteShopItemUseCase
import com.example.cleanarchitectureapp.domain.EditShopItemUseCase
import com.example.cleanarchitectureapp.domain.GetShopListUseCase
import com.example.cleanarchitectureapp.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnabledState(shopItem: ShopItem) {
        val newShopItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newShopItem)
    }

}