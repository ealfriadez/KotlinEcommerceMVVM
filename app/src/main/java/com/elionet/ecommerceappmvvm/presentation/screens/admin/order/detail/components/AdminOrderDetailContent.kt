package com.elionet.ecommerceappmvvm.presentation.screens.admin.order.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.elionet.ecommerceappmvvm.domain.model.Order
import com.elionet.ecommerceappmvvm.ui.theme.Gray100
import com.elionet.ecommerceappmvvm.R
import com.elionet.ecommerceappmvvm.presentation.components.DefaultButton
import com.elionet.ecommerceappmvvm.presentation.screens.admin.order.detail.AdminOrderDetailViewModel
import com.optic.ecommerceappmvvm.presentation.screens.admin.order.detail.components.AdminOrderDetailItem

@Composable
fun AdminOrderDetailContent(paddingValues: PaddingValues, order: Order, vm: AdminOrderDetailViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Gray100)
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(items = order.orderHasProducts ?: listOf()) { orderHasProducts ->
                AdminOrderDetailItem(orderHasProducts = orderHasProducts)
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(topEnd = 40.dp, topStart = 40.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(modifier = Modifier.padding(30.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Fecha del pedido",
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = order.createdAt ?: "",
                            fontSize = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.reloj),
                        contentDescription = ""
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Cliente y telefono",
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "${order.client?.name} ${order.client?.lastname} - ${order.client?.phone}",
                            fontSize = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = ""
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Direccion de entrega",
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "${order.address?.address} - ${order.address?.neighborhood}",
                            fontSize = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.map),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "TOTAL: $${vm.totalToPay}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    DefaultButton(
                        modifier = Modifier,
                        text = "DESPACHAR",
                        onClick = { vm.updateStatus(order.id ?: "") }
                    )
                }

            }
        }
    }


    
}