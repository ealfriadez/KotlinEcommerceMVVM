package com.elionet.ecommerceappmvvm.di

import com.elionet.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.elionet.ecommerceappmvvm.data.repository.AuthRepositoryImpl
import com.elionet.ecommerceappmvvm.data.repository.UsersRepositoryImpl
import com.elionet.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.elionet.ecommerceappmvvm.data.repository.dataSource.UsersRemoteDataSource
import com.elionet.ecommerceappmvvm.domain.repository.AuthRepository
import com.elionet.ecommerceappmvvm.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository = AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

    @Provides
    fun provideUsersRepository(
        usersRemoteDataSource: UsersRemoteDataSource
    ): UsersRepository = UsersRepositoryImpl(usersRemoteDataSource)
}