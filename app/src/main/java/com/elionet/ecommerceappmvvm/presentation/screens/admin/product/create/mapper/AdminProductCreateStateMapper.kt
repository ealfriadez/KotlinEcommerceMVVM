package com.elionet.ecommerceappmvvm.presentation.screens.admin.product.create.mapper

import com.elionet.ecommerceappmvvm.domain.model.Product
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.create.AdminProductCreateState

fun AdminProductCreateState.toProduct(): Product{
    return Product(
        name = name,
        description = description,
        idCategory = idCategory,
        price = price
    )
}