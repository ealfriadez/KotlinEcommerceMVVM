package com.elionet.ecommerceappmvvm.presentation.navigation.graph.admin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.elionet.ecommerceappmvvm.presentation.navigation.Graph
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.admin.AdminCategoryScreen
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.roles.RolesScreen
import com.elionet.ecommerceappmvvm.presentation.screens.admin.category.create.AdminCategoryCreateScreen
import com.elionet.ecommerceappmvvm.presentation.screens.admin.home.AdminHomeScreen
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
    }
}