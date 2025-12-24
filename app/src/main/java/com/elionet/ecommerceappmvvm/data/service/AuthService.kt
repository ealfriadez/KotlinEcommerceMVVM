package com.elionet.ecommerceappmvvm.data.service

import com.elionet.ecommerceappmvvm.domain.model.AuthResponse
import com.elionet.ecommerceappmvvm.domain.model.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    //http://192.168.1.5:3000/auth/login
    //@FormUrlEncoded
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>

}