package com.elionet.ecommerceappmvvm.domain.repository

import com.elionet.ecommerceappmvvm.domain.model.User
import com.elionet.ecommerceappmvvm.domain.util.Resource
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

interface UsersRepository {

    suspend fun update(id: String, user: User): Resource<User>
    suspend fun updateWithImage(id: String, user: User, file: File): Resource<User>
}