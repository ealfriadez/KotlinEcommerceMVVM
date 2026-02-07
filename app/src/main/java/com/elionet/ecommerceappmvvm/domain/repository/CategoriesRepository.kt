package com.elionet.ecommerceappmvvm.domain.repository

import com.elionet.ecommerceappmvvm.domain.model.Category
import com.elionet.ecommerceappmvvm.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import java.io.File

interface CategoriesRepository {

    suspend fun createCategory(category: Category, file: File): Resource<Category>
    fun getCategories(): Flow<Resource<List<Category>>>
    suspend fun update(id: String, category: Category): Resource<Category>
    suspend fun updateWithImage(id: String, category: Category, file: File): Resource<Category>
    suspend fun delete(id: String): Resource<Unit>
}