package com.elionet.ecommerceappmvvm.presentation.screens.client.address.create.mapper

import com.elionet.ecommerceappmvvm.domain.model.Address
import com.elionet.ecommerceappmvvm.presentation.screens.client.address.create.ClientAddressCreateState

fun ClientAddressCreateState.toAddress(): Address{

    return Address(
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}