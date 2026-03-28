package com.optic.ecommerceappmvvm.presentation.screens.client.order.detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.elionet.ecommerceappmvvm.domain.model.OrderHasProducts

@Composable
fun ClientOrderDetailItem(orderHasProducts: OrderHasProducts) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(10.dp)),
            model = orderHasProducts.product.image1,
            contentDescription = ""
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = orderHasProducts.product.name,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Cantidad: ${orderHasProducts.quantity}",
            )
        }
    }
}