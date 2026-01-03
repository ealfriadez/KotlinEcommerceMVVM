package com.elionet.ecommerceappmvvm.presentation.navigation.screen.profile

sealed class ProfileScreen(val route: String) {

    object ProfileUpdate : ProfileScreen(route = "profile/update")
}