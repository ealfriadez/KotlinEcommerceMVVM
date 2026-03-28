package com.elionet.ecommerceappmvvm.data.repository

import com.elionet.ecommerceappmvvm.domain.model.Order
import com.elionet.ecommerceappmvvm.domain.repository.OrdersRepository
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.domain.util.ResponseToRequest
import com.elionet.ecommerceappmvvm.data.dataSource.remote.OrdersRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OrdersRepositoryImpl(private val remoteDataSource: OrdersRemoteDataSource): OrdersRepository {

    override fun findAll(): Flow<Resource<List<Order>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findAll()))
    }

    override fun findByClient(idClient: String): Flow<Resource<List<Order>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findByClient(idClient)))
    }

    override suspend fun updateStatus(id: String): Resource<Order> = ResponseToRequest.send(
        remoteDataSource.updateStatus(id)
    )
}