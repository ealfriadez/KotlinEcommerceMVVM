package com.elionet.ecommerceappmvvm.domain.useCase.categories

import com.elionet.ecommerceappmvvm.domain.model.Category
import com.elionet.ecommerceappmvvm.domain.repository.CategoriesRepository
import java.io.File

class GetCategoriesUseCase(private val repository: CategoriesRepository) {

    suspend operator fun invoke() = repository.getCategories()
}
