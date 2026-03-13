package com.elionet.ecommerceappmvvm.domain.repository

import com.elionet.ecommerceappmvvm.domain.model.ShoppingBagProduct
import kotlinx.coroutines.flow.Flow

interface ShoppingBagRepository {

    suspend fun add(product: ShoppingBagProduct)
    suspend fun delete(id: String)
    fun findAll(): Flow<List<ShoppingBagProduct>>
    suspend fun findById(id: String): ShoppingBagProduct?
}