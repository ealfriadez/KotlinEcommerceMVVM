package com.elionet.ecommerceappmvvm.domain.useCase.categories

import com.elionet.ecommerceappmvvm.domain.model.Category
import com.elionet.ecommerceappmvvm.domain.repository.CategoriesRepository
import java.io.File

class CreateCategoryUseCase(private val repository: CategoriesRepository) {

    suspend operator fun invoke(category: Category, file: File) = repository.createCategory(category, file)
}
