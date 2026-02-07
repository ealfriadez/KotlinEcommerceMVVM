package com.elionet.ecommerceappmvvm.presentation.screens.admin.category.list.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.elionet.ecommerceappmvvm.domain.util.Resource
import com.elionet.ecommerceappmvvm.presentation.components.ProgressBar
import com.elionet.ecommerceappmvvm.presentation.screens.admin.category.list.AdminCategoryListViewModel

@Composable
fun GetCategories(vm: AdminCategoryListViewModel = hiltViewModel()){
    when(val response = vm.categoriesResponse) {
        Resource.Loading -> {
            ProgressBar()
        }

        is Resource.Success -> {
            //401 TOKEN
            Log.d("GetCategories", "Data: ${response.data}")
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