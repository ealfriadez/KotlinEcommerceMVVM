package com.elionet.ecommerceappmvvm.data.repository

import com.elionet.ecommerceappmvvm.data.dataSource.remote.UsersRemoteDataSource
import com.elionet.ecommerceappmvvm.domain.model.User
import com.elionet.ecommerceappmvvm.domain.repository.UsersRepository
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.domain.util.ResponseToRequest
import java.io.File
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(

    private val usersRemoteDataSource: UsersRemoteDataSource

): UsersRepository {

    override suspend fun update(id: String, user: User): Resource<User> = ResponseToRequest.send(
        usersRemoteDataSource.update(id, user)
    )

    override suspend fun updateWithImage(
        id: String,
        user: User,
        file: File
    ): Resource<User> = ResponseToRequest.send(
        usersRemoteDataSource.updateWithImage(id, user, file)
    )
}