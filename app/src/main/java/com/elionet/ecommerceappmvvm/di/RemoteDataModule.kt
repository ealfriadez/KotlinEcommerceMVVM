package com.elionet.ecommerceappmvvm.di

import com.elionet.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.elionet.ecommerceappmvvm.data.repository.dataSource.UsersRemoteDataSource
import com.elionet.ecommerceappmvvm.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.elionet.ecommerceappmvvm.data.repository.dataSourceImpl.UsersRemoteDataSourceImpl
import com.elionet.ecommerceappmvvm.data.service.AuthService
import com.elionet.ecommerceappmvvm.data.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource =
        AuthRemoteDataSourceImpl(authService)

    @Provides
    fun provideUsersRemoteDataSource(usersService: UsersService): UsersRemoteDataSource =
        UsersRemoteDataSourceImpl(usersService)
}