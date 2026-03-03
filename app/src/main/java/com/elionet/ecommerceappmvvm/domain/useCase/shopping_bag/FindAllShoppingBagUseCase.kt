package com.elionet.ecommerceappmvvm.domain.useCase.shopping_bag

import com.elionet.ecommerceappmvvm.domain.repository.ShoppingBagRepository

class FindAllShoppingBagUseCase(private val repositoy: ShoppingBagRepository) {

    operator fun invoke() = repositoy.findAll()
}