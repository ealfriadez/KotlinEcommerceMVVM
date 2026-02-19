package com.elionet.ecommerceappmvvm.data.dataSource.local

import com.elionet.ecommerceappmvvm.data.dataSource.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductsLocalDataSource {

    suspend fun insert(product: ProductEntity)
    suspend fun insertAll(products: List<ProductEntity>)
    suspend fun findAll(): Flow<List<ProductEntity>>
    suspend fun findByCategory(idCategory: String): Flow<List<ProductEntity>>
    suspend fun update(id: String, name: String, description: String, image1: String, image2: String, price: Double)
    suspend fun delete(id: String)
}