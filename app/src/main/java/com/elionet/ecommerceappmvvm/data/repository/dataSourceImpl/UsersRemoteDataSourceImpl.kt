package com.elionet.ecommerceappmvvm.data.repository.dataSourceImpl

import com.elionet.ecommerceappmvvm.data.repository.dataSource.UsersRemoteDataSource
import com.elionet.ecommerceappmvvm.data.service.UsersService
import com.elionet.ecommerceappmvvm.domain.model.User
import retrofit2.Response

class UsersRemoteDataSourceImpl(private val usersService: UsersService): UsersRemoteDataSource {

    override suspend fun update(id: String, user: User): Response<User> = usersService.update(id, user)

}