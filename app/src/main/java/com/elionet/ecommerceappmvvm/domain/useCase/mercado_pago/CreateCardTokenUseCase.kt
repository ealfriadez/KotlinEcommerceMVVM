package com.elionet.ecommerceappmvvm.domain.useCase.mercado_pago

import com.elionet.ecommerceappmvvm.domain.model.CardTokenBody
import com.elionet.ecommerceappmvvm.domain.repository.MercadoPagoRepository

class CreateCardTokenUseCase(private val repository: MercadoPagoRepository) {

    suspend operator fun invoke(cardTokenBody: CardTokenBody) = repository.createCardToken(cardTokenBody)

}