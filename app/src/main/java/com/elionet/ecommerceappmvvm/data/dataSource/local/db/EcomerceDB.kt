package com.elionet.ecommerceappmvvm.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.elionet.ecommerceappmvvm.data.dataSource.local.dao.CategoriesDao
import com.elionet.ecommerceappmvvm.data.dataSource.local.dao.ProductsDao
import com.elionet.ecommerceappmvvm.data.dataSource.local.dao.ShoppingBagDao
import com.elionet.ecommerceappmvvm.data.dataSource.local.entity.CategoryEntity
import com.elionet.ecommerceappmvvm.data.dataSource.local.entity.ProductEntity
import com.elionet.ecommerceappmvvm.data.dataSource.local.entity.ShoppingBagProductEntity

@Database(
    entities = [CategoryEntity::class, ProductEntity::class, ShoppingBagProductEntity::class],
    version = 1,
    exportSchema = false
)
abstract class EcomerceDB: RoomDatabase() {

    abstract fun categoriesDao(): CategoriesDao
    abstract fun productsDao(): ProductsDao
    abstract fun shoppingBagDao(): ShoppingBagDao
}