package com.elionet.ecommerceappmvvm.presentation.navigation.screen.roles

sealed class RolesScreen(val route: String) {

    object Roles : RolesScreen(route = "roles")
}