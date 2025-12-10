package com.elionet.ecommerceappmvvm.presentation.screens.auth.login

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.elionet.ecommerceappmvvm.presentation.screens.auth.login.components.LoginContent

@Composable
fun LoginScreen(){
    Scaffold() { paddingValues ->
        LoginContent(paddingValues)
    }
}