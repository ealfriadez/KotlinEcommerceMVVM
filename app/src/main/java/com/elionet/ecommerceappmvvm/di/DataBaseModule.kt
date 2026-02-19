package com.elionet.ecommerceappmvvm.di

import android.app.Application
import androidx.room.Room
import com.elionet.ecommerceappmvvm.data.dataSource.local.dao.CategoriesDao
import com.elionet.ecommerceappmvvm.data.dataSource.local.dao.ProductsDao
import com.elionet.ecommerceappmvvm.data.dataSource.local.db.EcomerceDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(app: Application):
            EcomerceDB = Room.databaseBuilder(
            app,
            EcomerceDB::class.java,
            "ecommerce_db"
            )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideCategoriesDao(db: EcomerceDB): CategoriesDao = db.categoriesDao()

    @Provides
    @Singleton
    fun provideProductsDao(db: EcomerceDB): ProductsDao = db.productsDao()

}