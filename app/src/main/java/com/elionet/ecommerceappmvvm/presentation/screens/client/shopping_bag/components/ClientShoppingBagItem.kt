package com.elionet.ecommerceappmvvm.presentation.screens.client.shopping_bag.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp)),
            model = shoppingBagProduct.image1,
            contentDescription = ""
        )
        Column() {
            Text(text = shoppingBagProduct.name)
            Spacer(modifier = Modifier.height(5.dp))
            Card(
                modifier = Modifier
                    .width(110.dp)
                    .height(40.dp),
                shape = RoundedCornerShape(20.dp),
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
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = shoppingBagProduct.quantity.toString(),
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        modifier = Modifier.clickable{ vm.addItem(shoppingBagProduct) },
                        text = "+",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column() {
            Text(text = (shoppingBagProduct.price * shoppingBagProduct.quantity).toString())
            Spacer(modifier = Modifier.height(7.dp))
            Image(
                modifier = Modifier
                    .size(25.dp)
                    .clickable { vm.deleteItem(shoppingBagProduct.id) },
                painter = painterResource(id = R.drawable.trash),
                contentDescription = ""
            )
        }
    }
}