package com.elionet.ecommerceappmvvm.domain.useCase.shopping_bag

import com.elionet.ecommerceappmvvm.domain.model.ShoppingBagProduct
import com.elionet.ecommerceappmvvm.domain.repository.ShoppingBagRepository

class AddUseCase(private val repositoy: ShoppingBagRepository) {

    suspend operator fun invoke(shoppingBagProduct: ShoppingBagProduct) {
        repositoy.add(shoppingBagProduct)
    }
}