package com.elionet.ecommerceappmvvm.data.mapper

import com.elionet.ecommerceappmvvm.data.dataSource.local.entity.ProductEntity
import com.elionet.ecommerceappmvvm.domain.model.Product

fun ProductEntity.toProduct(): Product{
    return Product(
        id = id,
        name = name,
        description = description,
        image1 = image1,
        image2 = image2,
        price = price,
        idCategory = idCategory,
        imagesToUpdate = null
    )
}

fun Product.toProductEntity(): ProductEntity{
    return ProductEntity(
        id = id ?: "",
        name = name,
        description = description,
        image1 = image1 ?: "",
        image2 = image2 ?: "",
        price = price,
        idCategory = idCategory
    )
}