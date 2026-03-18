package com.elionet.ecommerceappmvvm.presentation.screens.client.address.create

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.screens.client.address.create.components.ClientAddressCreateContent
import com.elionet.ecommerceappmvvm.presentation.screens.client.address.list.components.ClientAddressListContent

@Composable
fun ClientAddressCreateScreen(navController: NavHostController){

    Scaffold() {
        paddingValues ->
        ClientAddressCreateContent(paddingValues = paddingValues)

    }
}