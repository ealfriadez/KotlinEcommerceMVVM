package com.elionet.ecommerceappmvvm.domain.repository

import com.elionet.ecommerceappmvvm.domain.model.User
import com.elionet.ecommerceappmvvm.domain.util.Resource

interface UsersRepository {

    suspend fun update(id: String, user: User): Resource<User>
}