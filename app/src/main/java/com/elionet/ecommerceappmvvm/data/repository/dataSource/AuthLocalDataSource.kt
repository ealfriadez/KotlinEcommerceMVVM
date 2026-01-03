package com.elionet.ecommerceappmvvm.data.repository.dataSource

import com.elionet.ecommerceappmvvm.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {

    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>
}