package com.elionet.ecommerceappmvvm.presentation.screens.client.shopping_bag.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil.compose.AsyncImage
import com.elionet.ecommerceappmvvm.R
import com.elionet.ecommerceappmvvm.domain.model.ShoppingBagProduct
import com.elionet.ecommerceappmvvm.presentation.screens.client.shopping_bag.ClientShoppingBagViewModel
import com.elionet.ecommerceappmvvm.ui.theme.Gray700

@Composable
fun ClientShoppingBagItem(
    shoppingBagProduct: ShoppingBagProduct,
    vm: ClientShoppingBagViewModel = hiltViewModel()
){
    Row(
        modifier = Modifier
            .fillMaxWidth() // <-- CORRECCIÓN: Ocupa todo el ancho
            .padding(horizontal = 10.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically // Centra los elementos verticalmente
    ) {
        AsyncImage(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(10.dp)),
            model = shoppingBagProduct.image1,
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(5.dp))
        // CORRECCIÓN: Columna central con peso para empujar el precio a la derecha
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .weight(1f) // <-- CORRECCIÓN: Usa el espacio sobrante
        ) {
            Text(
                modifier = Modifier
                    .width(150.dp),
                text = shoppingBagProduct.name,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(5.dp))
            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(30.dp),
                shape = RoundedCornerShape(10.dp), // Forma más rectangular como el tutorial
                colors = CardDefaults.cardColors(
                    containerColor = Gray700
                )
            ){
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        modifier = Modifier.clickable{ vm.substracItem(shoppingBagProduct) },
                        text = "-",
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = shoppingBagProduct.quantity.toString(),
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        modifier = Modifier.clickable{ vm.addItem(shoppingBagProduct) },
                        text = "+",
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "%.2f".format(shoppingBagProduct.price * shoppingBagProduct.quantity),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(7.dp))
            Image(
                modifier = Modifier
                    .size(30.dp)
                    .clickable { vm.deleteItem(shoppingBagProduct.id) },
                painter = painterResource(id = R.drawable.trash),
                contentDescription = "Eliminar"
            )
        }
    }
}