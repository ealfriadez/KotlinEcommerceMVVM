package com.elionet.ecommerceappmvvm.presentation.screens.admin.product.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.domain.model.Product

@Composable
fun AdminProductListContent(
    paddingValues: PaddingValues
){
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ) {
        /*items(items = products){product ->
            //AdminProductListItem(navController, product)
        }*/
    }
}