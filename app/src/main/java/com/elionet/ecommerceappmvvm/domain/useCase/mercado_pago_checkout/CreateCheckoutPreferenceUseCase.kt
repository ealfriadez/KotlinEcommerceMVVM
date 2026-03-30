package com.elionet.ecommerceappmvvm.domain.useCase.mercado_pago_checkout

import com.elionet.ecommerceappmvvm.domain.model.CheckoutRequest
import com.elionet.ecommerceappmvvm.domain.repository.MercadoPagoCheckoutRepository

class CreateCheckoutPreferenceUseCase(private val repository: MercadoPagoCheckoutRepository) {

    suspend operator fun invoke(checkoutRequest: CheckoutRequest) = repository.createCheckoutPreference(checkoutRequest)

}