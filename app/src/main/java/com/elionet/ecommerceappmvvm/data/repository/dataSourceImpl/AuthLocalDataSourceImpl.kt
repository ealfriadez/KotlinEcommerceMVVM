package com.elionet.ecommerceappmvvm.data.repository.dataSourceImpl

import com.elionet.ecommerceappmvvm.data.datastore.AuthDataStore
import com.elionet.ecommerceappmvvm.data.repository.dataSource.AuthLocalDataSource
import com.elionet.ecommerceappmvvm.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDataStore: AuthDataStore): AuthLocalDataSource{

    override suspend fun saveSession(authResponse: AuthResponse) = authDataStore.saveUser(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authDataStore.getData()

}