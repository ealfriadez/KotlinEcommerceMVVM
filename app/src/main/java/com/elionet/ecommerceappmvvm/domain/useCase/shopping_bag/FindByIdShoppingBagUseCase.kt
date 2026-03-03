package com.elionet.ecommerceappmvvm.domain.useCase.shopping_bag

import com.elionet.ecommerceappmvvm.domain.repository.ShoppingBagRepository

class FindByIdShoppingBagUseCase(private val repositoy: ShoppingBagRepository) {

    suspend operator fun invoke(id: String) = repositoy.findById(id)
}