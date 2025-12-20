package com.elionet.ecommerceappmvvm.domain.repository

import com.elionet.ecommerceappmvvm.domain.model.AuthResponse
import com.elionet.ecommerceappmvvm.domain.util.Response


interface AuthRepository {

    suspend fun login(email: String, password: String): Response<AuthResponse>
}