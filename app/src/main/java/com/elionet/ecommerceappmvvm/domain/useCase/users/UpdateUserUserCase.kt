package com.elionet.ecommerceappmvvm.domain.useCase.users

import com.elionet.ecommerceappmvvm.domain.model.User
import com.elionet.ecommerceappmvvm.domain.repository.UsersRepository

class UpdateUserUserCase (private val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User) = repository.update(id, user)

}