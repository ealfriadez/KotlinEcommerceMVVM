package com.elionet.ecommerceappmvvm.domain.useCase.categories

import com.elionet.ecommerceappmvvm.domain.model.Category
import com.elionet.ecommerceappmvvm.domain.repository.CategoriesRepository

class CreateCategoriesUseCase(private val repository: CategoriesRepository) {

    suspend operator fun invoke(category: Category) = repository.createCategory(category)
}
