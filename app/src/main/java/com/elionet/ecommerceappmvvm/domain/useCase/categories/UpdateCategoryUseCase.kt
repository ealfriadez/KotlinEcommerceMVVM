package com.elionet.ecommerceappmvvm.domain.useCase.categories

import com.elionet.ecommerceappmvvm.domain.model.Category
import com.elionet.ecommerceappmvvm.domain.repository.CategoriesRepository
import java.io.File

class UpdateCategoryUseCase(private val repository: CategoriesRepository) {

    suspend operator fun invoke(id: String, category: Category) = repository.update(id, category)
}
