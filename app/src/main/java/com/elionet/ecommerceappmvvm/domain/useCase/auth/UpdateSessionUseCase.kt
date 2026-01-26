package com.elionet.ecommerceappmvvm.domain.useCase.auth

import com.elionet.ecommerceappmvvm.domain.model.User
import com.elionet.ecommerceappmvvm.domain.repository.AuthRepository

class UpdateSessionUseCase constructor(private val repository: AuthRepository){

    suspend operator fun invoke(user: User) = repository.updateSession(user)
}