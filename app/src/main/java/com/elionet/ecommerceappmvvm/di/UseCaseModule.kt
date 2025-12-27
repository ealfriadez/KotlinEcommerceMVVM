package com.elionet.ecommerceappmvvm.di

import com.elionet.ecommerceappmvvm.domain.repository.AuthRepository
import com.elionet.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.GetSessionDataUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.LoginUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.RegisterUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.SaveSessionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository)
    )
}