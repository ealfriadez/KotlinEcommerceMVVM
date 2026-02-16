package com.elionet.ecommerceappmvvm.domain.useCase.products

data class ProductsUseCase(
    //val findAll: FindAllProductsUseCase,
    val findByCategory: FindByCategoryUseCase,
    val createProduct: CreateProductUseCase,
    val updateProduct: UpdateProductUseCase,
    val updateProductWithImageUseCase: UpdateProductWithImageUseCase,
    //val delete: DeleteProductUseCase
)
