package com.elionet.ecommerceappmvvm.data.repository.dataSourceImpl

import com.elionet.ecommerceappmvvm.data.repository.dataSource.CategoriesRemoteDataSource
import com.elionet.ecommerceappmvvm.data.service.CategoriesService
import com.elionet.ecommerceappmvvm.domain.model.Category
import com.elionet.ecommerceappmvvm.domain.repository.CategoriesRepository
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import java.io.File

class CategoriesRepositoryImpl(private val categoriesRemoteDataSource: CategoriesRemoteDataSource): CategoriesRepository {

    override suspend fun createCategory(category: Category): Resource<Category> = ResponseToRequest.send(
        categoriesRemoteDataSource.create(category)
    )

    override fun getCategories(): Flow<Resource<List<Category>>> {
        TODO("Not yet implemented")
    }

    override suspend fun update(
        id: String,
        category: Category
    ): Resource<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Resource<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Resource<Unit> {
        TODO("Not yet implemented")
    }
}