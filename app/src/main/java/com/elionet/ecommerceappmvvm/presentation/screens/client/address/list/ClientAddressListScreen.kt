package com.elionet.ecommerceappmvvm.presentation.screens.client.address.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTopBar
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.client.ShoppingBagScreen
import com.elionet.ecommerceappmvvm.presentation.screens.client.address.list.components.GetAddress
import com.elionet.ecommerceappmvvm.ui.theme.Gray200

@Composable
fun ClientAddressListScreen(
    navController: NavHostController,
    vm: ClientAddressListViewModel = hiltViewModel()
){

    vm.getSessionData()

    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Mis direcciones",
                navController = navController,
                upAvailable = true
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(bottom = 20.dp),
                onClick = {
                    navController.navigate(route = ShoppingBagScreen.AddressCreate.route)
                },
                containerColor = Gray200   // 🔥 reemplaza backgroundColor
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    ) {
        paddingValues ->
        GetAddress(paddingValues)
    }
}