package com.elionet.ecommerceappmvvm.data.service

import com.elionet.ecommerceappmvvm.domain.model.Category
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface CategoriesService {

    @GET("categories")
    suspend fun getCategories(): Response<List<Category>>

    @POST("categories")
    suspend fun create(
        @Body category: Category
    ): Response<Category>

    @PUT("categories/{id}")
    suspend fun update(
        @Path("id") id: String,
        @Body category: Category
    ): Response<Category>

    @Multipart
    @PUT("categories/{id}")
    suspend fun updateWithImage(
        @Part file: MultipartBody.Part,
        @Path("id") id: String,
        @Path("name") name: RequestBody,
        @Path("description") description: RequestBody,
    ): Response<Category>

    @DELETE("categories/{id}")
    suspend fun delete(
        @Path("id") id: String
    ): Response<Unit>
}