package com.elionet.ecommerceappmvvm.domain.repository

import com.elionet.ecommerceappmvvm.domain.model.AuthResponse
import com.elionet.ecommerceappmvvm.domain.model.User
import com.elionet.ecommerceappmvvm.domain.util.Resource
import kotlinx.coroutines.flow.Flow


interface AuthRepository {

    suspend fun login(email: String, password: String): Resource<AuthResponse>

    suspend fun register(user: User): Resource<AuthResponse>

    suspend fun saveSession(authResponse: AuthResponse)

    suspend fun logout()

    fun getSessionData(): Flow<AuthResponse>
}