package com.elionet.ecommerceappmvvm.data.repository

import com.elionet.ecommerceappmvvm.data.dataSource.remote.AddressRemoteDataSource
import com.elionet.ecommerceappmvvm.domain.model.Address
import com.elionet.ecommerceappmvvm.domain.repository.AddressRepository
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AddressRepositoryImpl(private val remoteDataSource: AddressRemoteDataSource): AddressRepository {

    override suspend fun create(address: Address): Resource<Address> = ResponseToRequest.send(
        remoteDataSource.create(address)
    )

    override fun findByUser(idUser: String): Flow<Resource<List<Address>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findByUser(idUser)))
    }
}