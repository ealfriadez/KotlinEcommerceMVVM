package com.elionet.ecommerceappmvvm.data.dataSource.local

import com.elionet.ecommerceappmvvm.data.dataSource.local.datastore.AuthDataStore
import com.elionet.ecommerceappmvvm.domain.model.AuthResponse
import com.elionet.ecommerceappmvvm.domain.model.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDataStore: AuthDataStore): AuthLocalDataSource{

    override suspend fun saveSession(authResponse: AuthResponse) = authDataStore.saveUser(authResponse)
    override suspend fun updateSession(user: User) = authDataStore.update(user)
    override suspend fun logout() = authDataStore.delete()
    override fun getSessionData(): Flow<AuthResponse> = authDataStore.getData()
}