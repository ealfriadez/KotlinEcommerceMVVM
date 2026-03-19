package com.elionet.ecommerceappmvvm.presentation.screens.admin.product.create

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.create.components.AdminProductCreateContent
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.create.components.CreateProduct
import com.elionet.ecommerceappmvvm.ui.theme.Gray200

@Composable
fun AdminProductCreateScreen(
    navController: NavHostController,
    categoryParam: String
){
    Log.d("AdminProductCreateScreen", "Category: $categoryParam")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nuevo producto",
                upAvailable = true,
                navController = navController
            )
        },
        containerColor = Gray200   // 🔥 reemplaza backgroundColor
    ) { paddingValues ->
        AdminProductCreateContent(paddingValues = paddingValues)
    }
    CreateProduct()
}