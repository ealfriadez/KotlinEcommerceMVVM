package com.elionet.ecommerceappmvvm.data.repository

import com.elionet.ecommerceappmvvm.data.dataSource.remote.service.MercadoPagoCheckoutService
import com.elionet.ecommerceappmvvm.data.mapper.toCategoryEntity
import com.elionet.ecommerceappmvvm.domain.model.CheckoutRequest
import com.elionet.ecommerceappmvvm.domain.model.CheckoutResponse
import com.elionet.ecommerceappmvvm.domain.repository.MercadoPagoCheckoutRepository
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.domain.util.ResponseToRequest

class MercadoPagoCheckoutRepositoryImpl(
    private val service: MercadoPagoCheckoutService
): MercadoPagoCheckoutRepository {
    override suspend fun createCheckoutPreference(checkoutRequest: CheckoutRequest): Resource<CheckoutResponse> {
        ResponseToRequest.send(service.createCheckoutPreference(checkoutRequest)).run {
            return when(this) {
                is Resource.Success -> {
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }
}