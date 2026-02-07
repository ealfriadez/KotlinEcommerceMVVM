package com.elionet.ecommerceappmvvm.domain.useCase.categories

data class CategoriesUseCase(
    val createCategory: CreateCategoryUseCase,
    val getCategories: GetCategoriesUseCase
)
