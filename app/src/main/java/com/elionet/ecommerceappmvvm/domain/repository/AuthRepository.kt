package com.elionet.ecommerceappmvvm.domain.repository

import com.elionet.ecommerceappmvvm.domain.model.AuthResponse
import com.elionet.ecommerceappmvvm.domain.util.Resource


interface AuthRepository {

    suspend fun login(email: String, password: String): Resource<AuthResponse>
}