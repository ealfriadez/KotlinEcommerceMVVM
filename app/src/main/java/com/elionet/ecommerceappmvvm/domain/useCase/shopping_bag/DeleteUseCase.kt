package com.elionet.ecommerceappmvvm.domain.useCase.shopping_bag

import com.elionet.ecommerceappmvvm.domain.model.ShoppingBagProduct
import com.elionet.ecommerceappmvvm.domain.repository.ShoppingBagRepository

class DeleteUseCase(private val repositoy: ShoppingBagRepository) {

    suspend operator fun invoke(id: String) {
        repositoy.delete(id)
    }
}