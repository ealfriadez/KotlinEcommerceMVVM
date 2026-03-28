package com.elionet.ecommerceappmvvm.data.dataSource.remote.service

import com.elionet.ecommerceappmvvm.domain.model.CheckoutRequest
import com.elionet.ecommerceappmvvm.domain.model.CheckoutResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MercadoPagoCheckoutService {

    @POST("payment/create")
    fun createCheckoutPreference(@Body request: CheckoutRequest): Call<CheckoutResponse>

}