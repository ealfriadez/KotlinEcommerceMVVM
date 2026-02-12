package com.elionet.ecommerceappmvvm.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.elionet.ecommerceappmvvm.presentation.navigation.Graph
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.admin.AdminCategoryScreen
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.roles.RolesScreen
import com.elionet.ecommerceappmvvm.presentation.screens.admin.category.create.AdminCategoryCreateScreen
import com.elionet.ecommerceappmvvm.presentation.screens.admin.category.update.AdminCategoryUpdateScreen
import com.elionet.ecommerceappmvvm.presentation.screens.admin.home.AdminHomeScreen
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.create.AdminProductCreateScreen
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.list.AdminProductListScreen
import com.elionet.ecommerceappmvvm.presentation.screens.client.home.ClientHomeScreen
import com.elionet.ecommerceappmvvm.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.AdminCategoryNavGraph(navController: NavHostController){
    navigation(
        route = Graph.ADMIN_CATEGORY,
        startDestination = AdminCategoryScreen.CategoryCreate.route
    ){
        composable(route = AdminCategoryScreen.CategoryCreate.route){
            AdminCategoryCreateScreen(navController = navController)
        }

        composable(route = AdminCategoryScreen.CategoryUpdate
            .route,
            arguments = listOf(navArgument("category"){
                type = NavType.StringType
            })){
            it.arguments?.getString("category").let {
                AdminCategoryUpdateScreen(navController, it!!)
            }
        }

        composable(route = AdminCategoryScreen.ProductList
            .route,
            arguments = listOf(navArgument("category"){
                type = NavType.StringType
            })){
            it.arguments?.getString("category").let {
                AdminProductListScreen(navController, it!!)
            }
        }

        composable(route = AdminCategoryScreen.ProductCreate
            .route,
            arguments = listOf(navArgument("category"){
                type = NavType.StringType
            })){
            it.arguments?.getString("category").let {
                AdminProductCreateScreen(navController, it!!)
            }
        }
    }
}