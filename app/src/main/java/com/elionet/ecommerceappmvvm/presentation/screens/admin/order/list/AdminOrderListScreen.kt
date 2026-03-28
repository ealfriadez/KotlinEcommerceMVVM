package com.optic.ecommerceappmvvm.presentation.screens.admin.order.list

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.screens.admin.order.list.AdminOrderListViewModel
import com.optic.ecommerceappmvvm.presentation.screens.admin.order.list.components.GetOrders

@Composable
fun AdminOrderListScreen(navController: NavHostController, vm: AdminOrderListViewModel = hiltViewModel()) {

    vm.getOrders()

    Scaffold() { paddingValues ->  
        GetOrders(navController = navController, paddingValues = paddingValues)
    }
    
}