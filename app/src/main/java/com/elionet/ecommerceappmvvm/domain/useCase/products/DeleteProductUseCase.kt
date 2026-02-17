package com.elionet.ecommerceappmvvm.domain.useCase.products

import com.elionet.ecommerceappmvvm.domain.model.Product
import com.elionet.ecommerceappmvvm.domain.repository.ProductsRepository

class DeleteProductUseCase(private val repository: ProductsRepository) {

    suspend operator fun invoke(id: String) = repository.delete(id)
}
