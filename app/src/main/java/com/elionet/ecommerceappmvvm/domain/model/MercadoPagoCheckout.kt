package com.elionet.ecommerceappmvvm.domain.model

data class CheckoutRequest(
    val title: String,
    val quantity: Int,
    val unit_price: Double
)

data class CheckoutResponse(
    val init_point: String
)