package com.elionet.ecommerceappmvvm.presentation.screens.auth.register

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.elionet.ecommerceappmvvm.presentation.screens.auth.register.components.Register
import com.elionet.ecommerceappmvvm.presentation.screens.auth.register.components.RegisterContent
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController){

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = true

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color(0xFFF8F8F8), // <-- AQUÍ EL COLOR QUE QUIERES
            darkIcons = useDarkIcons
        )
    }

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Registro",
                upAvailable = true,
                navCotroller = navController
            )
        },
    ) { paddingValues ->
        RegisterContent(paddingValues = paddingValues)
    }
    Register(navController)
}