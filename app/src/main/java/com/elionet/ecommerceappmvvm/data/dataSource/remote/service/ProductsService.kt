package com.elionet.ecommerceappmvvm.data.dataSource.remote.service

import com.elionet.ecommerceappmvvm.domain.model.Product
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ProductsService {

    @GET("products/category/{id_category}")
    suspend fun findByCategory(
        @Path("id_category") idCategory: String
    ): Response<List<Product>>

   @Multipart
    @POST("products")
    suspend fun create(
        @Part file: Array<MultipartBody.Part?>,
        @Part("name") name: RequestBody,
        @Part("description") description: RequestBody,
        @Part("id_category") idCategory: RequestBody,
        @Part("price") price: RequestBody
    ): Response<Product>
}