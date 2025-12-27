package com.elionet.ecommerceappmvvm.data.repository.dataSource

import com.elionet.ecommerceappmvvm.domain.model.AuthResponse
import com.elionet.ecommerceappmvvm.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email: String, password: String): Response<AuthResponse>

    suspend fun register(user: User): Response<AuthResponse>

}