package com.elionet.ecommerceappmvvm.domain.repository

import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.domain.model.Order
import kotlinx.coroutines.flow.Flow

interface OrdersRepository {
    fun findAll(): Flow<Resource<List<Order>>>
    fun findByClient(idClient: String): Flow<Resource<List<Order>>>
    suspend fun updateStatus(id: String): Resource<Order>
}