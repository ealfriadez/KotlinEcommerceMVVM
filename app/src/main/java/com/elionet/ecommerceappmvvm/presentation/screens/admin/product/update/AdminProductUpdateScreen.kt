package com.elionet.ecommerceappmvvm.presentation.screens.admin.product.update

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.update.components.AdminProductUpdateContent
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.update.components.UpdateProduct
import com.elionet.ecommerceappmvvm.ui.theme.Gray200

@Composable
fun AdminProductUpdateScreen(
    navController: NavHostController,
    productParam: String
){
    Log.d("AdminProductUpdateScreen", "Product: $productParam")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Actualizar producto",
                upAvailable = true,
                navController = navController
            )
        },
        containerColor = Gray200   // 🔥 reemplaza backgroundColor
    ) { paddingValues ->
        AdminProductUpdateContent(paddingValues = paddingValues)
    }
    UpdateProduct()
}