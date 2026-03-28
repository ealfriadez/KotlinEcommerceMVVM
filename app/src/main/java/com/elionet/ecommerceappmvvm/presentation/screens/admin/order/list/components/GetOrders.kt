package com.optic.ecommerceappmvvm.presentation.screens.admin.order.list.components

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.presentation.components.ProgressBar
import com.elionet.ecommerceappmvvm.presentation.screens.admin.order.list.components.AdminOrderListContent
import com.elionet.ecommerceappmvvm.presentation.screens.admin.order.list.AdminOrderListViewModel

@Composable
fun GetOrders(navController: NavHostController, paddingValues: PaddingValues, vm: AdminOrderListViewModel = hiltViewModel()) {
    when(val response = vm.ordersResponse) {
        Resource.Loading -> {
            ProgressBar()
        }
        is Resource.Success -> {
            AdminOrderListContent(paddingValues, response.data, navController)
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}