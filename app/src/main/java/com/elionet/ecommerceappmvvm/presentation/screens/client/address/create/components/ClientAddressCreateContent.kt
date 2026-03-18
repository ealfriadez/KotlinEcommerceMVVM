package com.elionet.ecommerceappmvvm.presentation.screens.client.address.create.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ClientAddressCreateContent(paddingValues: PaddingValues){

    Text(
        modifier = Modifier.padding(paddingValues),
        text = "ClientAddressCreateScreen")
}