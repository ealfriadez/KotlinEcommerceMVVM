package com.elionet.ecommerceappmvvm.presentation.screens.client.address.create

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.elionet.ecommerceappmvvm.presentation.screens.client.address.create.components.ClientAddressCreateContent
import com.elionet.ecommerceappmvvm.presentation.screens.client.address.create.components.CreateAddress
import com.elionet.ecommerceappmvvm.presentation.screens.client.address.list.components.ClientAddressListContent
import com.elionet.ecommerceappmvvm.ui.theme.Gray200

@Composable
fun ClientAddressCreateScreen(
    navController: NavHostController,
    vm: ClientAddressCreateViewModel = hiltViewModel()
){

    vm.getSessionData()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nueva direccion",
                navController = navController,
                upAvailable = true
            )
        },
        containerColor = Gray200   // 🔥 reemplaza backgroundColor
    ) {
        paddingValues ->
        ClientAddressCreateContent(paddingValues = paddingValues)
    }
    CreateAddress()
}