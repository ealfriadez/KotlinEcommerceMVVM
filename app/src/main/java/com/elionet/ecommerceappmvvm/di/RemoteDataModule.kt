package com.elionet.ecommerceappmvvm.di

import com.elionet.ecommerceappmvvm.data.dataSource.remote.AuthRemoteDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.remote.CategoriesRemoteDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.remote.UsersRemoteDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.remote.AuthRemoteDataSourceImpl
import com.elionet.ecommerceappmvvm.data.dataSource.remote.CategoriesRemoteDataSourceImpl
import com.elionet.ecommerceappmvvm.data.dataSource.remote.UsersRemoteDataSourceImpl
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.AuthService
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.CategoriesService
import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.UsersService
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

    @Provides
    fun provideCategoriesRemoteDataSource(categoriesService: CategoriesService):  CategoriesRemoteDataSource =
        CategoriesRemoteDataSourceImpl(categoriesService)
}