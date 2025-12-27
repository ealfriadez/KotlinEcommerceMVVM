package com.elionet.ecommerceappmvvm.presentation.navigation.screen

sealed class AuthScreen(val route: String) {

    object Login : AuthScreen(route = "login")

    object Register : AuthScreen(route = "register")

    object Home : AuthScreen(route = "home")

    object Roles : AuthScreen(route = "roles")
}