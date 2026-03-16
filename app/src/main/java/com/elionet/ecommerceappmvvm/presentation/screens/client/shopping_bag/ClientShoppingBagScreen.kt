package com.elionet.ecommerceappmvvm.presentation.screens.client.shopping_bag

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.screens.client.shopping_bag.components.ClientShoppingBagContent

@Composable
fun ClientShoppingBagScreen(
    navController: NavHostController,
    vm: ClientShoppingBagViewModel = hiltViewModel()
){
    Scaffold() { paddingValues ->
        ClientShoppingBagContent(paddingValues, vm.shoppingBag.toList())
    }
}