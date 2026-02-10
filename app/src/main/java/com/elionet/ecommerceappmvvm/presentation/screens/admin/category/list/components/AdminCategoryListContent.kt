package com.elionet.ecommerceappmvvm.presentation.screens.admin.category.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.domain.model.Category

@Composable
fun AdminCategoryListContent(
    navController: NavHostController,
    categories: List<Category>,
    paddingValues: PaddingValues
){
    LazyColumn(
        modifier = Modifier
            //.padding(paddingValues = paddingValues)
            .fillMaxSize()
            .padding(top = paddingValues.calculateTopPadding()),
        contentPadding = PaddingValues(
            top = 16.dp,
            bottom = 155.dp
        )
    ) {
        items(
            items = categories
        ) { category ->
            AdminCategoryListItem(navController, category)
        }
    }
}