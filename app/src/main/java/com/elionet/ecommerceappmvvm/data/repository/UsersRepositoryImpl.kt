package com.elionet.ecommerceappmvvm.data.repository

import com.elionet.ecommerceappmvvm.data.repository.dataSource.UsersRemoteDataSource
import com.elionet.ecommerceappmvvm.domain.model.User
import com.elionet.ecommerceappmvvm.domain.repository.UsersRepository
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.domain.util.ResponseToRequest

class UsersRepositoryImpl(

    private val usersRemoteDataSource: UsersRemoteDataSource

): UsersRepository {

    override suspend fun update(id: String, user: User): Resource<User> = ResponseToRequest.send(
        usersRemoteDataSource.update(id, user)
    )
}