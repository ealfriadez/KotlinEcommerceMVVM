package com.elionet.ecommerceappmvvm.di

import com.elionet.ecommerceappmvvm.data.datastore.AuthDataStore
import com.elionet.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.elionet.ecommerceappmvvm.data.repository.dataSourceImpl.AuthLocalDataSourceImpl
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
}