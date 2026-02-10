package com.elionet.ecommerceappmvvm.presentation.navigation.graph.admin

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elionet.ecommerceappmvvm.presentation.navigation.Graph
import com.elionet.ecommerceappmvvm.presentation.navigation.graph.profile.ProfileNavGraph
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.admin.AdminScreen
import com.elionet.ecommerceappmvvm.presentation.screens.admin.category.list.AdminCategoryListScreen
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.list.AdminProductListScreen
import com.elionet.ecommerceappmvvm.presentation.screens.profile.info.ProfileScreen

@Composable
fun AdminNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.ProductList.route
    ){
        composable(route = AdminScreen.ProductList.route){
            AdminProductListScreen()
        }

        composable(route = AdminScreen.CategoryList.route){
           AdminCategoryListScreen(navController)
        }

        composable(route = AdminScreen.Profile.route){
           ProfileScreen(navController)
        }

        ProfileNavGraph(navController)

        AdminCategoryNavGraph(navController)

    }
}