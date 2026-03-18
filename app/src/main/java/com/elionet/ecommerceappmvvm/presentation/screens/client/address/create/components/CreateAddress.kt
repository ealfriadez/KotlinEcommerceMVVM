package com.elionet.ecommerceappmvvm.presentation.screens.client.address.create.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.presentation.components.ProgressBar
import com.elionet.ecommerceappmvvm.presentation.screens.client.address.create.ClientAddressCreateViewModel

@Composable
fun CreateAddress(vm: ClientAddressCreateViewModel = hiltViewModel()) {

    when(val response = vm.addressResponse) {
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {

            //401 TOKEN
            Log.d("CreateCategory", "Data: ${response.data}")

            vm.clearForm()

            Toast.makeText(LocalContext.current, "Los datos se han creado correctamente", Toast.LENGTH_LONG).show()
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