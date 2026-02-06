package com.elionet.ecommerceappmvvm.data.repository.dataSourceImpl

import com.elionet.ecommerceappmvvm.data.repository.dataSource.CategoriesRemoteDataSource
import com.elionet.ecommerceappmvvm.data.repository.dataSource.UsersRemoteDataSource
import com.elionet.ecommerceappmvvm.data.service.CategoriesService
import com.elionet.ecommerceappmvvm.data.service.UsersService
import com.elionet.ecommerceappmvvm.domain.model.Category
import com.elionet.ecommerceappmvvm.domain.model.User
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class CategoriesRemoteDataSourceImpl(private val categoriesService: CategoriesService): CategoriesRemoteDataSource {

     override suspend fun getCategories(): Response<List<Category>> = categoriesService.getCategories()

    override suspend fun create(category: Category): Response<Category> = categoriesService.create(category)

    override suspend fun update(
        id: String,
        category: Category
    ): Response<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Response<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Response<Unit> {
        TODO("Not yet implemented")
    }

}