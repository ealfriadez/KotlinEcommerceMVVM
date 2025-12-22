package com.elionet.ecommerceappmvvm.domain.useCase.auth

import com.elionet.ecommerceappmvvm.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)
}