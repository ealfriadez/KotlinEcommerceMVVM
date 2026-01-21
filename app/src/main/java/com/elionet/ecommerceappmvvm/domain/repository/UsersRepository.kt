package com.elionet.ecommerceappmvvm.domain.repository

import com.elionet.ecommerceappmvvm.domain.model.User
import com.elionet.ecommerceappmvvm.domain.util.Resource
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface UsersRepository {

    suspend fun update(id: String, user: User): Resource<User>
}