package com.elionet.ecommerceappmvvm.domain.useCase.mercado_pago

import com.elionet.ecommerceappmvvm.domain.repository.MercadoPagoRepository

class GetIdentificationTypeUseCase(private val repository: MercadoPagoRepository) {

    operator fun invoke() = repository.getIdentificationTypes()

}