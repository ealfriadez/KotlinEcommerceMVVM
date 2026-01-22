package com.elionet.ecommerceappmvvm.presentation.screens.profile.update.mapper

import com.elionet.ecommerceappmvvm.domain.model.User
import com.elionet.ecommerceappmvvm.presentation.screens.profile.update.ProfileUpdateState

fun ProfileUpdateState.toUser(): User{
    return User(
        name = name,
        lastname = lastName,
        phone = phone,
        image = image
    )
}