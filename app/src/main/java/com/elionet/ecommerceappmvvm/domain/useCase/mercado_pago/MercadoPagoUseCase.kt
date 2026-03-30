package com.elionet.ecommerceappmvvm.domain.useCase.mercado_pago

data class MercadoPagoUseCase(
    val getIdentificationType: GetIdentificationTypeUseCase,
    val getInstallments: GetInstallmentsUseCase,
    val createCardToken: CreateCardTokenUseCase,
    val createPayment: CreatePaymentUseCase
)
