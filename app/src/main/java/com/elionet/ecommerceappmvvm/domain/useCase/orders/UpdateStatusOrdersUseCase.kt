package com.optic.ecommerceappmvvm.domain.useCase.orders

import com.elionet.ecommerceappmvvm.domain.repository.OrdersRepository

class UpdateStatusOrdersUseCase(private val repository: OrdersRepository) {

    suspend operator fun invoke(id: String) = repository.updateStatus(id)

}