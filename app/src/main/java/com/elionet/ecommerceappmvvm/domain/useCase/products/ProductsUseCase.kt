package com.elionet.ecommerceappmvvm.domain.useCase.products

data class ProductsUseCase(
    val findAll: FindAllUseCase,
    val findByCategory: FindByCategoryUseCase,
    val createProduct: CreateProductUseCase,
    val updateProduct: UpdateProductUseCase,
    val updateProductWithImageUseCase: UpdateProductWithImageUseCase,
    val deleteProduct: DeleteProductUseCase
)
