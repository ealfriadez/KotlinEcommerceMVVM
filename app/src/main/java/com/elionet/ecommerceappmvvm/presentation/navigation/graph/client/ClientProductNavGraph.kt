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
import com.elionet.ecommerceappmvvm.presentation.screens.client.shopping_bag.ClientShoppingBagScreen

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

        // AGREGA ESTO: La ruta hacia la bolsa de compras
        composable(route = "client/shopping_bag") { // Asegúrate que el route coincida con tu ClientProductScreen
            ClientShoppingBagScreen(navController)
        }
    }
}