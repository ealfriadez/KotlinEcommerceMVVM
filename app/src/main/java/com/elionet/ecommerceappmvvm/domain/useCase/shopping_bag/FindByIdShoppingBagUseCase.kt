package com.elionet.ecommerceappmvvm.domain.useCase.shopping_bag

import com.elionet.ecommerceappmvvm.domain.repository.ShoppingBagRepository

class FindByIdShoppingBagUseCase(private val repository: ShoppingBagRepository) {

    suspend operator fun invoke(id: String) = repository.findById(id)
}