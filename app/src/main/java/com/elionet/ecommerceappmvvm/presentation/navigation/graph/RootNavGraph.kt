package com.elionet.ecommerceappmvvm.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.navigation.Graph

@Composable}

fun RootNavGraph(navController: NavHostController){
    NavHost(
        navController = navControllerv,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ){

    }
}