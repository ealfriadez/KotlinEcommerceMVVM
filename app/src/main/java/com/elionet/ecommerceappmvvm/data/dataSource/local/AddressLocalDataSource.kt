package com.elionet.ecommerceappmvvm.data.dataSource.local

import com.elionet.ecommerceappmvvm.data.dataSource.local.entity.AddressEntity
import com.elionet.ecommerceappmvvm.data.dataSource.local.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

interface AddressLocalDataSource {

    suspend fun insert(address: AddressEntity)
    suspend fun insertAll(address: List<AddressEntity>)
    suspend fun findByUser(idUser: String): Flow<List<AddressEntity>>
    suspend fun update(id: String, address: String, neighborhood: String)
    suspend fun delete(id: String)
}