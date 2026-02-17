package com.elionet.ecommerceappmvvm.presentation.screens.admin.product.list.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.presentation.components.ProgressBar
import com.elionet.ecommerceappmvvm.presentation.screens.admin.category.list.AdminCategoryListViewModel
import com.elionet.ecommerceappmvvm.presentation.screens.admin.category.list.components.AdminCategoryListContent
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.list.AdminProductListViewModel

@Composable
fun DeleteProduct(
    vm: AdminProductListViewModel = hiltViewModel()
){
    when(val response = vm.productDeleteResponse) {
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {
            //401 TOKEN
            Log.d("DeleteProduct", "Data: ${response.data}")

            Toast.makeText(LocalContext.current, "El producto se elimino correctamente", Toast.LENGTH_LONG).show()
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