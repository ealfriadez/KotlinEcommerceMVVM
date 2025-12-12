package com.elionet.ecommerceappmvvm.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.elionet.ecommerceappmvvm.presentation.navigation.Graph
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.elionet.ecommerceappmvvm.presentation.screens.auth.login.LoginScreen
import com.elionet.ecommerceappmvvm.presentation.screens.auth.register.RegisterScreen
import com.elionet.ecommerceappmvvm.ui.theme.KotlinEcommerceMVVMTheme

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController){
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ){
        composable(route = AuthScreen.Login.route){
            LoginScreen(navController)
        }

        composable(route = AuthScreen.Register.route){
            RegisterScreen(navController)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview(){
    KotlinEcommerceMVVMTheme {
        LoginScreen(rememberNavController())
    }
}