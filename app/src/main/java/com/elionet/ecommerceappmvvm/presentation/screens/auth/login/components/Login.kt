package com.elionet.ecommerceappmvvm.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.presentation.components.ProgressBar
import com.elionet.ecommerceappmvvm.presentation.navigation.Graph
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.elionet.ecommerceappmvvm.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(navController: NavHostController, vm: LoginViewModel = hiltViewModel()) {

    when(val response = vm.loginResponse) {
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {
            LaunchedEffect(Unit) {
                vm.saveSession(response.data)
                if (response.data.user?.roles!!.size > 1) {  //MAS DE UN ROL
                    navController.navigate(route = Graph.ROLES) {
                        popUpTo(Graph.AUTH) {
                            inclusive = true
                        }
                    }
                } else {  //UN SOLO ROL
                    navController.navigate(route = Graph.ROLES) {
                        popUpTo(Graph.AUTH) {
                            inclusive = true
                        }
                    }
                }
            }
        }

        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }

        else -> {
            if(response != null){
                Toast.makeText(LocalContext.current, "Error desconocido 2", Toast.LENGTH_LONG).show()
            }
        }
    }
}