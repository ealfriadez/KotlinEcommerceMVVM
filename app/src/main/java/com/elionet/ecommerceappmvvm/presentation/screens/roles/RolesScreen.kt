package com.elionet.ecommerceappmvvm.presentation.screens.roles

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.elionet.ecommerceappmvvm.presentation.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navController: NavHostController){

    Scaffold(
        topBar = {
            DefaultTopBar(title = "Selecciona un rol")
        }
    ) { paddingValues ->
        RolesContent(paddingValues, navController = navController)
    }
}