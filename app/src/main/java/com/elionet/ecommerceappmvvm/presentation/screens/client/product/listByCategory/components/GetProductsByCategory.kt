package com.elionet.ecommerceappmvvm.presentation.screens.client.product.listByCategory.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.presentation.components.ProgressBar
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.list.AdminProductListViewModel
import com.elionet.ecommerceappmvvm.presentation.screens.client.product.listByCategory.ClientProductByCategoryListViewModel

@Composable
fun GetProductsByCategory(
    navController: NavHostController,
    paddingValues: PaddingValues,
    vm: ClientProductByCategoryListViewModel = hiltViewModel()
){
    when(val response = vm.productResponse) {
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {
            //401 TOKEN
            Log.d("GetProductsByCategory", "Data: ${response.data}")

            ClientProductByCategoryListContent(navController, paddingValues, products = response.data)
        }

        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }

        else -> {
            if(response != null){
                Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}