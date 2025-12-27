package com.elionet.ecommerceappmvvm.domain.useCase.auth

import com.elionet.ecommerceappmvvm.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository){

    operator fun invoke() = repository.getSessionData()
}