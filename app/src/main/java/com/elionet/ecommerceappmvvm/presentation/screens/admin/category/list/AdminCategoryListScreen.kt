package com.elionet.ecommerceappmvvm.presentation.screens.admin.category.list

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
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.elionet.ecommerceappmvvm.presentation.navigation.Graph
import com.elionet.ecommerceappmvvm.presentation.screens.admin.category.list.components.AdminCategoryListContent
import com.elionet.ecommerceappmvvm.presentation.screens.admin.category.list.components.GetCategories

@Composable
fun AdminCategoryListScreen(navController: NavHostController){

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(bottom = 70.dp),
                onClick = {navController.navigate(Graph.ADMIN_CATEGORY)}
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "")
            }
        }
    ) { paddingValues ->
        AdminCategoryListContent(paddingValues = paddingValues)
    }
    GetCategories()
}