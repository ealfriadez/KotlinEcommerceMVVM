package com.elionet.ecommerceappmvvm.data.repository.dataSourceImpl

import com.elionet.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.elionet.ecommerceappmvvm.data.service.AuthService
import com.elionet.ecommerceappmvvm.domain.model.AuthResponse
import com.elionet.ecommerceappmvvm.domain.model.LoginRequest
import com.elionet.ecommerceappmvvm.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {
    override suspend fun login(
        email: String,
        password: String
    ): Response<AuthResponse> = authService.login(LoginRequest(email, password))

    override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)

}