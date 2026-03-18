package com.elionet.ecommerceappmvvm.presentation.screens.client.shopping_bag.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.components.DefaultButton
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.client.ShoppingBagScreen
import com.elionet.ecommerceappmvvm.presentation.screens.client.shopping_bag.ClientShoppingBagViewModel
import com.elionet.ecommerceappmvvm.ui.theme.Gray100

@Composable
fun ClientShoppingBagBottomBar(navController: NavHostController, vm: ClientShoppingBagViewModel = hiltViewModel()){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Gray100),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier = Modifier.padding(vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "TOTAL",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )
            Text(
                text = "S/ " + "%.2f".format(vm.total),
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )
        }
        DefaultButton(
            modifier = Modifier
                .padding(vertical = 20.dp),
            text = "Confirmar Orden",
            onClick = { navController.navigate(route = ShoppingBagScreen.AddressList.route) }
        )
    }
}