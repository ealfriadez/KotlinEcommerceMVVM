package com.elionet.ecommerceappmvvm.presentation.screens.admin.product.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.elionet.ecommerceappmvvm.R
import com.elionet.ecommerceappmvvm.domain.model.Product
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.admin.AdminCategoryScreen
import com.elionet.ecommerceappmvvm.presentation.screens.admin.product.list.AdminProductListViewModel

@Composable
fun AdminProductListItem(
    navController: NavHostController,
    product: Product,
    vm: AdminProductListViewModel = hiltViewModel()
){
    Column(
        Modifier
            .padding(start = 20.dp, end = 20.dp, top = 15.dp)
            .height(80.dp)
    ) {
        Row(){
            AsyncImage(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(10.dp)),
                model = product.image1,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(10.dp))
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
            Spacer(modifier = Modifier.width(15.dp))
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(35.dp)
                        .clickable {
                                    navController.navigate(
                                            route = AdminCategoryScreen.ProductUpdate.passProduct(product.toJson()
                                            )
                                        )
                                   },
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.height(3.dp))
                Image(
                    modifier = Modifier
                        .size(35.dp)
                        .clickable{},
                    painter = painterResource(id = R.drawable.trash),
                    contentDescription = ""
                )
            }
        }
        // Cambia Divider por HorizontalDivider
        HorizontalDivider(
            modifier = Modifier.padding(start = 70.dp), // Así se hace el "indent" ahora
            thickness = 1.dp,                           // Grosor de la línea
            color = Color.LightGray                     // Color que ya tenías
        )
    }
}