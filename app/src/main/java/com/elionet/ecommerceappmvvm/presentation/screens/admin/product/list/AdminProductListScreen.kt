package com.elionet.ecommerceappmvvm.presentation.screens.admin.product.list

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.domain.model.Category
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.elionet.ecommerceappmvvm.presentation.navigation.Graph
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.admin.AdminCategoryScreen
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.list.components.AdminProductListContent
import com.elionet.ecommerceappmvvm.presentation.screens.client.product.list.components.ClientProductListContent

@Composable
fun AdminProductListScreen(
    navController: NavHostController,
    categoryParam: String
){
    Log.d("AdminProductListScreen", "Category: $categoryParam")
    val categoryParse = Category.fromJson(categoryParam).toJson()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(bottom = 70.dp),
                onClick = {navController.navigate(AdminCategoryScreen.ProductCreate.passCategory(categoryParse))}
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "")
            }
        }
    ) {paddingValues ->
        AdminProductListContent(paddingValues = paddingValues)

    }
}