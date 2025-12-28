package com.elionet.ecommerceappmvvm.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elionet.ecommerceappmvvm.presentation.navigation.Graph

@Composable
fun RootNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ){
        AuthNavGraph(navController = navController)
        RolesNavGraph(navController = navController)
        composable(route = Graph.CLIENT){

        }
    }
}