package com.elionet.ecommerceappmvvm.presentation.screens.client.address.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ClientAddressListContent(
    paddingValues: PaddingValues
    ){

    Text(
        modifier = Modifier.padding(paddingValues),
        text = "ClientAddressListContent")
}