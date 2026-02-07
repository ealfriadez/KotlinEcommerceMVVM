package com.elionet.ecommerceappmvvm.presentation.screens.admin.category.create.mapper

import com.elionet.ecommerceappmvvm.domain.model.Category
import com.elionet.ecommerceappmvvm.presentation.screens.admin.category.create.AdminCategoryCreateState

fun AdminCategoryCreateState.toCategory(): Category {
    return Category(
        name = name,
        description = description
    )
}