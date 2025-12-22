package com.elionet.ecommerceappmvvm.di

import com.elionet.ecommerceappmvvm.data.dataSource.remote.AuthRemoteDataSource
import com.elionet.ecommerceappmvvm.data.dataSource.remote.AuthRemoteDataSourceImpl
import com.elionet.ecommerceappmvvm.data.repository.AuthRepositoryImpl
import com.elionet.ecommerceappmvvm.domain.repository.AuthRepository
import com.elionet.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository)
    )
}