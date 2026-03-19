package com.elionet.ecommerceappmvvm.presentation.screens.client.address.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.elionet.ecommerceappmvvm.domain.model.Address

@Composable
fun ClientAddressListContent(
    paddingValues: PaddingValues,
    addressList: List<Address>
    ){

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues) // Esto evita que el primer ítem se meta debajo de la barra
    ) {
        items(
            items = addressList
        ){ address ->
            ClientAddressListItem(address = address)
        }
    }
}