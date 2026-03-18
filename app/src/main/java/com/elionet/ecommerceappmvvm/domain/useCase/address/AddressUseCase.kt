package com.elionet.ecommerceappmvvm.domain.useCase.address

data class AddressUseCase(

    val createAddress: CreateAddressUseCase,
    val findByUserAddress: FindByUserAddressUseCase
)
