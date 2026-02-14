package com.elionet.ecommerceappmvvm.presentation.screens.admin.product.update.mapper

import com.elionet.ecommerceappmvvm.domain.model.Product
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.create.AdminProductCreateState
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.update.AdminProductUpdateState

fun AdminProductUpdateState.toProduct(): Product{
    return Product(
        name = name,
        description = description,
        idCategory = idCategory,
        price = price
    )
}