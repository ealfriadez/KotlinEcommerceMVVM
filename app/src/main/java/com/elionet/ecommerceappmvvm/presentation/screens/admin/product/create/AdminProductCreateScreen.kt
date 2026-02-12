package com.elionet.ecommerceappmvvm.presentation.screens.admin.product.create

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.create.components.AdminProductCreateContent

@Composable
fun AdminProductCreateScreen(
    navController: NavHostController,
    categoryParam: String
){
    Log.d("AdminProductCreateScreen", "Category: ${categoryParam}")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nueva categoria",
                upAvailable = true,
                navController = navController
            )
        },
    ) { paddingValues ->
        AdminProductCreateContent(paddingValues = paddingValues)

    }
}