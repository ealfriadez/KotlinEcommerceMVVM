package com.elionet.ecommerceappmvvm.presentation.screens.client.address.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.client.ShoppingBagScreen
import com.elionet.ecommerceappmvvm.presentation.screens.client.address.list.components.ClientAddressListContent

@Composable
fun ClientAddressListScreen(navController: NavHostController){

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(bottom = 20.dp),
                onClick = {navController.navigate(route = ShoppingBagScreen.AddressCreate.route)}
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "")
            }
        }
    ) {
        paddingValues ->
        ClientAddressListContent(paddingValues = paddingValues)

    }
}