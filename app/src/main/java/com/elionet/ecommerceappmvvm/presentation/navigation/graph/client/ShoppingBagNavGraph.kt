package com.elionet.ecommerceappmvvm.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.elionet.ecommerceappmvvm.presentation.navigation.Graph
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.client.ClientCategoryScreen
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.client.ClientProductScreen
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.client.ShoppingBagScreen
import com.elionet.ecommerceappmvvm.presentation.screens.client.address.create.ClientAddressCreateScreen
import com.elionet.ecommerceappmvvm.presentation.screens.client.address.list.ClientAddressListScreen
import com.elionet.ecommerceappmvvm.presentation.screens.client.address.list.components.ClientAddressListContent
import com.elionet.ecommerceappmvvm.presentation.screens.client.product.detail.ClientProductDetailScreen
import com.elionet.ecommerceappmvvm.presentation.screens.client.product.listByCategory.ClientProductByCategoryListScreen
import com.elionet.ecommerceappmvvm.presentation.screens.client.shopping_bag.ClientShoppingBagScreen

fun NavGraphBuilder.ShoppingBagNavGraph(navController: NavHostController){
    navigation(
        route = Graph.SHOPPING_BAG,
        startDestination = ShoppingBagScreen.ShoppingBag.route
    ){
        composable(
            route = ShoppingBagScreen.ShoppingBag.route,
        ){
            ClientShoppingBagScreen(navController)
        }
        composable(
            route = ShoppingBagScreen.AddressList.route,
        ){
            ClientAddressListScreen(navController)
        }
        composable(
            route = ShoppingBagScreen.AddressCreate.route,
        ){
            ClientAddressCreateScreen(navController)
        }
    }
}