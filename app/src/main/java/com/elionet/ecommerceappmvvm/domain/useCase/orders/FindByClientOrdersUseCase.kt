package com.optic.ecommerceappmvvm.domain.useCase.orders

import com.elionet.ecommerceappmvvm.domain.repository.OrdersRepository

class FindByClientOrdersUseCase(private val repository: OrdersRepository) {

    operator fun invoke(idClient: String) = repository.findByClient(idClient)

}