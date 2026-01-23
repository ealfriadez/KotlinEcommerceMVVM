package com.elionet.ecommerceappmvvm.presentation.screens.auth.register.mapper

import com.elionet.ecommerceappmvvm.domain.model.User
import com.elionet.ecommerceappmvvm.presentation.screens.auth.register.RegisterState

fun RegisterState.toUser(): User{
    return User(
        name = name,
        lastname = lastName,
        email = email,
        phone = phone,
        password = password
    )
}