package com.elionet.ecommerceappmvvm.presentation.screens.client.home.components

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.ClientScreen

@Composable
fun ClientBottomBar(navController: NavHostController) {

    val screens = listOf(
        ClientScreen.CategoryList,
        ClientScreen.ProductList,
        ClientScreen.Profile
    )

    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        NavigationBar {
            screens.forEach { screen ->
                ClientBottomBarItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}
