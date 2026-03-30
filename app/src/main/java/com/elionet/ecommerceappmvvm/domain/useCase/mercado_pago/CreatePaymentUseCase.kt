package com.elionet.ecommerceappmvvm.domain.useCase.mercado_pago

import com.elionet.ecommerceappmvvm.domain.model.PaymentBody
import com.elionet.ecommerceappmvvm.domain.repository.MercadoPagoRepository

class CreatePaymentUseCase(private val repository: MercadoPagoRepository) {

    suspend operator fun invoke(paymentBody: PaymentBody) = repository.createPayment(paymentBody)

}