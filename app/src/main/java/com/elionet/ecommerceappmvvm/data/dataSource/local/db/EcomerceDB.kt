package com.elionet.ecommerceappmvvm.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.elionet.ecommerceappmvvm.data.dataSource.local.dao.CategoriesDao
import com.elionet.ecommerceappmvvm.data.dataSource.local.entity.CategoryEntity

@Database(
    entities = [CategoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class EcomerceDB: RoomDatabase() {

    abstract fun categoriesDao(): CategoriesDao
}