package com.elionet.ecommerceappmvvm.data.mapper

import com.elionet.ecommerceappmvvm.data.dataSource.local.entity.ShoppingBagProductEntity
import com.elionet.ecommerceappmvvm.domain.model.ShoppingBagProduct

fun ShoppingBagProduct.toEntity(): ShoppingBagProductEntity{

    return ShoppingBagProductEntity(
        id= id,
        name = name,
        idCategory = idCategory,
        image1 = image1,
        price = price,
        quantity = quantity
    )
}

/*fun ShoppingBagProductEntity?.toShoppingBagProduct(): ShoppingBagProduct?{

    if (this == null) return null

    return ShoppingBagProduct(
        id = id ?: "", // Usamos el operador elvis ?: para asignar valores por defecto si el campo es null
        name = name ?: "Producto sin nombre",
        idCategory = idCategory ?: "",
        image1 = image1 ?: "",
        price = price ?: 0.0,
        quantity = quantity ?: 0
    )
}*/

fun ShoppingBagProductEntity.toShoppingBagProduct(): ShoppingBagProduct{

    return ShoppingBagProduct(
        id= id,
        name = name,
        idCategory = idCategory,
        image1 = image1,
        price = price,
        quantity = quantity
    )
}
