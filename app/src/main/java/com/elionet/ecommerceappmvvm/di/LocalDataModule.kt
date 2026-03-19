package com.elionet.ecommerceappmvvm.di

import com.elionet.ecommerceappmvvm.data.dataSource.local.AddressLocalDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.local.AddressLocalDataSourceImpl
import com.elionet.ecommerceappmvvm.data.dataSource.local.datastore.AuthDataStore
import com.elionet.ecommerceappmvvm.data.dataSource.local.AuthLocalDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.local.AuthLocalDataSourceImpl
import com.elionet.ecommerceappmvvm.data.dataSource.local.CategoriesLocalDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.local.CategoriesLocalDataSourceImpl
import com.elionet.ecommerceappmvvm.data.dataSource.local.ProductsLocalDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.local.ProductsLocalDataSourceImpl
import com.elionet.ecommerceappmvvm.data.dataSource.local.ShoppingBagLocalDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.local.ShoppingBagLocalDataSourceImpl
import com.elionet.ecommerceappmvvm.data.dataSource.local.dao.AddressDao
import com.elionet.ecommerceappmvvm.data.dataSource.local.dao.CategoriesDao
import com.elionet.ecommerceappmvvm.data.dataSource.local.dao.ProductsDao
import com.elionet.ecommerceappmvvm.data.dataSource.local.dao.ShoppingBagDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDataStore): AuthLocalDataSource =
        AuthLocalDataSourceImpl(authDatastore)

    @Provides
    fun provideCategoriesLocalDataSource(categoriesDao: CategoriesDao): CategoriesLocalDataSource =
        CategoriesLocalDataSourceImpl(categoriesDao)

    @Provides
    fun provideProductsLocalDataSource(productsDao: ProductsDao): ProductsLocalDataSource =
        ProductsLocalDataSourceImpl(productsDao)

    @Provides
    fun provideShoppingBagLocalDataSource(shoppingBagDao: ShoppingBagDao): ShoppingBagLocalDataSource =
        ShoppingBagLocalDataSourceImpl(shoppingBagDao)

    @Provides
    fun provideAddressLocalDataSource(addressDao: AddressDao): AddressLocalDataSource =
        AddressLocalDataSourceImpl(addressDao)
}