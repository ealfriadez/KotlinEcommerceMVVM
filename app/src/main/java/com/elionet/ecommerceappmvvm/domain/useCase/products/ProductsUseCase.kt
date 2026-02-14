package com.elionet.ecommerceappmvvm.domain.useCase.products

data class ProductsUseCase(
    //val findAll: FindAllProductsUseCase,
    val findByCategory: FindByCategoryUseCase,
    val createProduct: CreateProductUseCase,
    //val update: UpdateProductUseCase,
    //val delete: DeleteProductUseCase
)
