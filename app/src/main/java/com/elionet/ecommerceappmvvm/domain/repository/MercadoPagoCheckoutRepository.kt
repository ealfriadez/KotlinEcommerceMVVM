package com.elionet.ecommerceappmvvm.domain.repository

import com.elionet.ecommerceappmvvm.domain.model.CheckoutRequest
import com.elionet.ecommerceappmvvm.domain.model.CheckoutResponse
import com.elionet.ecommerceappmvvm.domain.util.Resource

interface MercadoPagoCheckoutRepository {

    suspend fun createCheckoutPreference(checkoutRequest: CheckoutRequest): Resource<CheckoutResponse>
}