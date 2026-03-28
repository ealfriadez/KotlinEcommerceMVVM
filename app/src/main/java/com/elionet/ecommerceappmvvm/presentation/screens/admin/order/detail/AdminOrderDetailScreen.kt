package com.elionet.ecommerceappmvvm.presentation.screens.admin.order.detail

import android.util.Log
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.elionet.ecommerceappmvvm.presentation.screens.admin.order.detail.components.AdminOrderDetailContent
import com.elionet.ecommerceappmvvm.presentation.screens.admin.order.detail.components.UpdateStatusOrder

@Composable
fun AdminOrderDetailScreen(navController: NavHostController, orderParam: String, vm: AdminOrderDetailViewModel = hiltViewModel()) {

    Log.d("AdminOrderDetailScreen", "Order param: ${orderParam}")

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Detalle de la orden",
                navController = navController,
                upAvailable = true
            )
        }
    ) { paddingValues ->  
        AdminOrderDetailContent(paddingValues, vm.order)
    }
    UpdateStatusOrder()
    
}