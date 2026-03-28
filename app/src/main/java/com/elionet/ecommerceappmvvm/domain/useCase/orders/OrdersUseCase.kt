package com.elionet.ecommerceappmvvm.domain.useCase.orders

import com.optic.ecommerceappmvvm.domain.useCase.orders.FindAllOrdersUseCase
import com.optic.ecommerceappmvvm.domain.useCase.orders.FindByClientOrdersUseCase
import com.optic.ecommerceappmvvm.domain.useCase.orders.UpdateStatusOrdersUseCase

data class OrdersUseCase(
    val findAllOrders: FindAllOrdersUseCase,
    val findByClientOrders: FindByClientOrdersUseCase,
    val updateStatusOrders: UpdateStatusOrdersUseCase
)
