package com.elionet.ecommerceappmvvm.domain.useCase.auth

import com.elionet.ecommerceappmvvm.domain.model.AuthResponse
import com.elionet.ecommerceappmvvm.domain.repository.AuthRepository

class LogoutUseCase constructor(private val repository: AuthRepository){

    suspend operator fun invoke() = repository.logout()
}