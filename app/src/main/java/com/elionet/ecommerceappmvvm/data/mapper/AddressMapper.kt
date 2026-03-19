package com.elionet.ecommerceappmvvm.data.mapper

import com.elionet.ecommerceappmvvm.data.dataSource.local.entity.AddressEntity
import com.elionet.ecommerceappmvvm.domain.model.Address

fun AddressEntity.toAddress(): Address {
    return Address(
        id =id,
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}

fun Address.toEntity(): AddressEntity {
    return AddressEntity(
        id =id ?: "",
        address = address,
        neighborhood = neighborhood,
        idUser = idUser
    )
}