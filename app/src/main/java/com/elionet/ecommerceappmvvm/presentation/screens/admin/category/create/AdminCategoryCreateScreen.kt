package com.elionet.ecommerceappmvvm.presentation.screens.admin.category.create

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.elionet.ecommerceappmvvm.presentation.screens.admin.category.create.components.AdminCategoryCreateContent
import com.elionet.ecommerceappmvvm.ui.theme.Gray200

@Composable
fun AdminCategoryCreateScreen(navController: NavHostController){

    Scaffold(
            topBar = {
                DefaultTopBar(
                    title = "Nueva categoria",
                    upAvailable = true,
                    navController = navController
                )
            },
        containerColor = Gray200   // 🔥 reemplaza backgroundColor
        ) {
        paddingValues ->
        AdminCategoryCreateContent(paddingValues = paddingValues)
    }
}