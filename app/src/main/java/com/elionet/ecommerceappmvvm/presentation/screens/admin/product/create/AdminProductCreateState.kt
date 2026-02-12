package com.elionet.ecommerceappmvvm.presentation.screens.admin.product.create

data class AdminProductCreateState(
    val name: String = "",
    val description: String = "",
    val iCategory: String = "",
    val image1: String = "",
    val image2: String = "",
    val price: Double = 0.0
)
