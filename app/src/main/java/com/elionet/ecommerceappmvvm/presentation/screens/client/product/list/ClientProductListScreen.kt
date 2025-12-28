package com.elionet.ecommerceappmvvm.presentation.screens.client.product.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.elionet.ecommerceappmvvm.presentation.screens.client.product.list.components.ClientProductListContent

@Composable
fun ClientProductListScreen(){
    Scaffold() { paddingValues ->
        ClientProductListContent(paddingValues = paddingValues)
    }
}