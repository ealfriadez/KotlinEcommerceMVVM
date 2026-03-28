package com.elionet.ecommerceappmvvm.presentation.screens.admin.order.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.domain.model.Order
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.admin.AdminOrderScreen
import com.elionet.ecommerceappmvvm.ui.theme.Gray100

@Composable
fun AdminOrderListItem(order: Order, navController: NavHostController) {

    Column(
        modifier = Modifier
            .padding(top = 20.dp, start = 20.dp, end = 20.dp)
            .clickable { navController.navigate(route = AdminOrderScreen.OrderDetail.passOrder(order.toJson())) }
//            .clickable { navController.navigate(route = AdminOrderScreen.OrderDetail.route) }
    ) {
        Text(
            text = "Orden #${order.id}",
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )

        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = "Pedido ${order.createdAt}",
            fontSize = 15.sp
        )
        Text(
            modifier = Modifier.padding(top = 5.dp),
            text = "Cliente ${ order.client?.name } ${ order.client?.lastname }",
            fontSize = 15.sp
        )
        Text(
            modifier = Modifier.padding(top = 5.dp),
            text = "Entregar en ${ order.address?.address }",
            fontSize = 15.sp
        )
        Text(
            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
            text = "Estado: ${ order.status }",
            fontSize = 15.sp
        )
        Divider(
            modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
            color = Gray100
        )
    }

}