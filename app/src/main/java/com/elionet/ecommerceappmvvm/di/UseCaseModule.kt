package com.elionet.ecommerceappmvvm.di

import com.elionet.ecommerceappmvvm.domain.repository.AuthRepository
import com.elionet.ecommerceappmvvm.domain.repository.UsersRepository
import com.elionet.ecommerceappmvvm.domain.useCase.auth.AuthUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.GetSessionDataUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.LoginUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.LogoutUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.RegisterUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.SaveSessionUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.auth.UpdateSessionUseCase
import com.elionet.ecommerceappmvvm.domain.useCase.users.UpdateUserUserCase
import com.elionet.ecommerceappmvvm.domain.useCase.users.UpdateUserWithImageCase
import com.elionet.ecommerceappmvvm.domain.useCase.users.UsersUseCase
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
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository),
        updateSession = UpdateSessionUseCase(authRepository)
    )

    @Provides
    fun provideUsersUseCase(usersRepository: UsersRepository) = UsersUseCase(
        updateUser = UpdateUserUserCase(usersRepository),
        updateUserWithImage = UpdateUserWithImageCase(usersRepository)
    )
}