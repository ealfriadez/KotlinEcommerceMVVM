package com.optic.ecommerceappmvvm.domain.useCase.orders

import com.elionet.ecommerceappmvvm.domain.repository.OrdersRepository

class FindAllOrdersUseCase(private val repository: OrdersRepository) {

    operator fun invoke() = repository.findAll()

}