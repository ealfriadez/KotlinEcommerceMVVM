package com.elionet.ecommerceappmvvm.data.repository

import android.util.Log
import com.elionet.ecommerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.elionet.ecommerceappmvvm.domain.model.AuthResponse
import com.elionet.ecommerceappmvvm.domain.repository.AuthRepository
import com.elionet.ecommerceappmvvm.domain.util.Resource

class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {

    override suspend fun login(email: String, password: String): Resource<AuthResponse> {
        return try {
            val result = authRemoteDataSource.login(email, password)
            Resource.Success(result.body()!!)
        }catch (e: Exception){
            Log.d("AuthRepositoryImpl", "login: ${e.message}")
            Resource.Failure(e)
        }
    }
}