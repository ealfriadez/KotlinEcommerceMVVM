package com.elionet.ecommerceappmvvm.domain.useCase.address

import com.elionet.ecommerceappmvvm.domain.model.Address
import com.elionet.ecommerceappmvvm.domain.repository.AddressRepository

class CreateAddressUseCase(private val repository: AddressRepository) {

    suspend operator fun invoke(address: Address) = repository.create(address)
}