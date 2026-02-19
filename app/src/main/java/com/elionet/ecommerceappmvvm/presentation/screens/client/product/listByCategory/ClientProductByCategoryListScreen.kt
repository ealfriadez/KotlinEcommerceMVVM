package com.elionet.ecommerceappmvvm.presentation.screens.client.product.listByCategory

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.domain.model.Category
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.admin.AdminCategoryScreen
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.list.components.DeleteProduct
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.list.components.GetProducts
import com.elionet.ecommerceappmvvm.presentation.screens.client.product.listByCategory.components.GetProductsByCategory

@Composable
fun ClientProductByCategoryListScreen(
    navController: NavHostController,
    categoryParam: String
){
    Log.d("ClientProductByCategoryListScreen", "Category: $categoryParam")
    val categoryParse = Category.fromJson(categoryParam).toJson()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Productos",
                upAvailable = true,
                navController = navController
            )
        }
    ) { paddingValues ->
        GetProductsByCategory(navController, paddingValues)
    }
}