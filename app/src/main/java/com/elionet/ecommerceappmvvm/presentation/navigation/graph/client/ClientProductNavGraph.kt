package com.elionet.ecommerceappmvvm.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.elionet.ecommerceappmvvm.presentation.navigation.Graph
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.client.ClientProductScreen
import com.elionet.ecommerceappmvvm.presentation.screens.client.product.detail.ClientProductDetailScreen

fun NavGraphBuilder.ClientProductNavGraph(navController: NavHostController){
    navigation(
        route = Graph.CLIENT_PRODUCT,
        startDestination = ClientProductScreen.ProductDetail.route
    ){
        composable(
            route = ClientProductScreen.ProductDetail.route,
            arguments = listOf(navArgument("product"){
                type = NavType.StringType
            })){
            it.arguments?.getString("product")?.let {
                ClientProductDetailScreen(navController, it)
            }
        }
    }
}