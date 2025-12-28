package com.elionet.ecommerceappmvvm.presentation.navigation.screen

sealed class RolesScreen(val route: String) {

    object Roles : RolesScreen(route = "roles")
}