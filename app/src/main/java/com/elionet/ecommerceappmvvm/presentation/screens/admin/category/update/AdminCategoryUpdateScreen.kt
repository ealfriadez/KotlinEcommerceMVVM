package com.elionet.ecommerceappmvvm.presentation.screens.admin.category.update

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.elionet.ecommerceappmvvm.presentation.screens.admin.category.update.components.AdminCategoryUpdateContent
import com.elionet.ecommerceappmvvm.presentation.screens.admin.category.update.components.UpdateCategory
import com.elionet.ecommerceappmvvm.ui.theme.Gray200

@Composable
fun AdminCategoryUpdateScreen(navController: NavHostController, categoryParam: String){

    Log.d("AdminCategoryUpdateScreen", "Data: $categoryParam")

    Scaffold(
            topBar = {
                DefaultTopBar(
                    title = "Actualizar categoría",
                    upAvailable = true,
                    navController = navController
                )
            },
        containerColor = Gray200   // 🔥 reemplaza backgroundColor
        ) {
        paddingValues ->
        AdminCategoryUpdateContent(paddingValues = paddingValues)
    }
    UpdateCategory()
}