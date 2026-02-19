package com.elionet.ecommerceappmvvm.presentation.screens.client.product.list.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.elionet.ecommerceappmvvm.domain.model.Product
import com.elionet.ecommerceappmvvm.presentation.screens.client.product.list.ClientProductListViewModel

@Composable
fun ClientProductListItem(
    navController: NavHostController,
    product: Product,
    vm: ClientProductListViewModel = hiltViewModel()
){
    Column(
        Modifier
            .padding(start = 20.dp, end = 20.dp, top = 15.dp)
            .height(80.dp)
    ) {
        Row(){
            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    text = product.name,
                    color = Color.Black,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = product.description,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = product.price.toString(),
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            AsyncImage(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(10.dp)),
                model = product.image1,
                contentDescription = ""
            )
        }
        // Cambia Divider por HorizontalDivider
        HorizontalDivider(
            modifier = Modifier.padding(end = 70.dp), // Así se hace el "indent" ahora
            thickness = 1.dp,                           // Grosor de la línea
            color = Color.LightGray                     // Color que ya tenías
        )
    }
}