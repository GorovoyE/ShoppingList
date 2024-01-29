package com.example.shoppinglist.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.shoppinglist.data.ShopListDao
import com.example.shoppinglist.data.mapper.ShopListMapper
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository
import javax.inject.Inject

class ShopListRepositoryImpl @Inject constructor(
    private val shopListDao: ShopListDao,
    private val mapper: ShopListMapper
) : ShopListRepository {

    override suspend fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        shopListDao.deleteShopItem(shopItem.id)
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }

    override suspend fun getShopItem(shopItemId: Int): ShopItem {
        val dbModel = shopListDao.getShopItem(shopItemId)
        return mapper.mapDmModelToEntity(dbModel)
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListDao.getShopList().map {
            mapper.mapListDbModelToListEntity(it)
        }
    }
}
