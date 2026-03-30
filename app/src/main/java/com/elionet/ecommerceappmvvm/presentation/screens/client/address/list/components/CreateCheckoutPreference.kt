package com.elionet.ecommerceappmvvm.presentation.screens.client.address.list.components

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
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
fun CreateCheckoutPreference(
    vm: ClientAddressListViewModel = hiltViewModel()
){
    when(val response = vm.mercadoPagoCheckoutResponse) {

        is Resource.Success -> {
            val init_point = response.data.init_point
            if(init_point != null){
                val customTabsIntent = CustomTabsIntent.Builder().build()
                customTabsIntent.launchUrl(LocalContext.current, Uri.parse(init_point))
            }
            else{
                Toast.makeText(LocalContext.current, "No hay respuesta del servidor", Toast.LENGTH_LONG).show()
            }
        }

        is Resource.Failure -> {
            Log.d("CreateCheckoutPreference", "Data: Fail")
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }

        else -> {
            if(response != null){
                Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}