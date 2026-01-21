package com.elionet.ecommerceappmvvm.data.service

import com.elionet.ecommerceappmvvm.domain.model.User
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface UsersService {

   //http://192.168.1.5:3000/users
   @PUT("users/upload/{id}")
    suspend fun update(
        @Path("id") id: String,
        @Body() user: User
    ): Response<User>
}