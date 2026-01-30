package com.elionet.ecommerceappmvvm.domain.useCase.users

import com.elionet.ecommerceappmvvm.domain.model.User
import com.elionet.ecommerceappmvvm.domain.repository.UsersRepository
import java.io.File

class UpdateUserWithImageCase (private val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User, file: File) = repository.updateWithImage(id, user, file)

}