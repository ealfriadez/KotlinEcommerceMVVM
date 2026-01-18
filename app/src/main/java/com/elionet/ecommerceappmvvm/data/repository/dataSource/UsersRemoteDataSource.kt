package com.elionet.ecommerceappmvvm.data.repository.dataSource

import com.elionet.ecommerceappmvvm.domain.model.User
import retrofit2.Response

interface UsersRemoteDataSource {

    suspend fun update(id: String, user: User): Response<User>

}