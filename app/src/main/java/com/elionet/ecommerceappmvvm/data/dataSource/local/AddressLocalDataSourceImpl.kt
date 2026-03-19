package com.elionet.ecommerceappmvvm.data.dataSource.local

import com.elionet.ecommerceappmvvm.data.dataSource.local.dao.AddressDao
import com.elionet.ecommerceappmvvm.data.dataSource.local.entity.AddressEntity
import kotlinx.coroutines.flow.Flow

class AddressLocalDataSourceImpl(private val addressDao: AddressDao): AddressLocalDataSource {

    override suspend fun insert(address: AddressEntity) = addressDao.insert(address)

    override suspend fun insertAll(address: List<AddressEntity>) = addressDao.insertAll(address)

    override suspend fun findByUser(idUser: String): Flow<List<AddressEntity>> = addressDao.findByUser(idUser)

    override suspend fun update(
        id: String,
        address: String,
        neighborhood: String
    ) = addressDao.update(id, address, neighborhood)

    override suspend fun delete(id: String) = addressDao.delete(id)
}