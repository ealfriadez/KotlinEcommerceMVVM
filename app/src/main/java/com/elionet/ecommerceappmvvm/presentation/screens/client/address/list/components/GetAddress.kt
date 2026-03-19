package com.elionet.ecommerceappmvvm.presentation.screens.client.address.list.components

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
import com.elionet.ecommerceappmvvm.presentation.screens.client.address.list.ClientAddressListViewModel

@Composable
fun GetAddress(
    paddingValues: PaddingValues,
    vm: ClientAddressListViewModel = hiltViewModel()
){
    when(val response = vm.addressResponse) {
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {
            //401 TOKEN
            Log.d("GetAddress-OK", "Data: ${response.data}")
           ClientAddressListContent(paddingValues, response.data)
        }

        is Resource.Failure -> {
            Log.d("GetAddress-FAIL", "Data: Fail")
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }

        else -> {
            if(response != null){
                Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}