package com.elionet.ecommerceappmvvm.presentation.screens.client.product.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.elionet.ecommerceappmvvm.presentation.screens.client.product.list.components.ClientProductListContent
import com.elionet.ecommerceappmvvm.presentation.screens.client.product.list.components.GetProducts

@Composable
fun ClientProductListScreen(
    navController: NavHostController
){
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Productos",
                navController = navController,
                enableActions = true
            )
        }
    ) { paddingValues ->
        GetProducts(navController = navController, paddingValues = paddingValues)
    }
}