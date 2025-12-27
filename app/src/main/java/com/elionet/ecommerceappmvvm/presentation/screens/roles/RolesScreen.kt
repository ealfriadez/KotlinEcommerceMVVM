package com.elionet.ecommerceappmvvm.presentation.screens.roles

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navController: NavHostController){

    Scaffold { paddingValues ->
        RolesContent(paddingValues)
    }
}