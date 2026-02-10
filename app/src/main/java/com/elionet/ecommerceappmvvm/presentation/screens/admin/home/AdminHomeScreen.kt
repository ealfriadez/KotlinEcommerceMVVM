package com.elionet.ecommerceappmvvm.presentation.screens.admin.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.elionet.ecommerceappmvvm.presentation.navigation.graph.admin.AdminNavGraph
import com.elionet.ecommerceappmvvm.presentation.screens.admin.home.components.AdminBottomBar

@Composable
fun AdminHomeScreen(navController: NavHostController = rememberNavController()){
    Scaffold(
        bottomBar = {
            AdminBottomBar(navController = navController)
        }
    ) { paddingValues ->
        AdminNavGraph(navController = navController)
        Text(
            modifier = Modifier.padding(paddingValues = paddingValues),
            text = ""
        )
    }
}