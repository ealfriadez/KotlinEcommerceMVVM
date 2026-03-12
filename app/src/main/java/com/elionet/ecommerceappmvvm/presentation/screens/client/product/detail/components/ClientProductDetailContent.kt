package com.elionet.ecommerceappmvvm.presentation.screens.client.product.detail.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.elionet.ecommerceappmvvm.presentation.components.DefaultButton
import com.elionet.ecommerceappmvvm.presentation.screens.client.product.detail.ClientProductDetailViewModel
import com.elionet.ecommerceappmvvm.ui.theme.Gray100
import com.elionet.ecommerceappmvvm.ui.theme.Gray700
import com.optic.ecommerceappmvvm.presentation.components.DotsIndicator
import com.optic.ecommerceappmvvm.presentation.components.SliderView
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientProductDetailContent(
    paddingValues: PaddingValues,
    vm: ClientProductDetailViewModel = hiltViewModel()
){
    val state = rememberPagerState(initialPage = 0) { vm.productImages.size }

    /*Column(Modifier.padding(paddingValues)) {
        SliderView(state = state, images = vm.productImages)
        Spacer(modifier = Modifier.height(4.dp))
        DotsIndicator(totalDots = vm.productImages.size, selectedIndex = state.currentPage)
    }*/




















    Box(
        Modifier.padding(paddingValues).fillMaxSize()
    ){
        Column(){
            SliderView(state = state, images = vm.productImages)
            Spacer(modifier = Modifier.height(4.dp))
            DotsIndicator(totalDots = vm.productImages.size, selectedIndex = state.currentPage)
        }
        Card(
            modifier = Modifier.padding(top = 310.dp),
            shape = RoundedCornerShape(
                topStart = 40.dp,
                topEnd = 40.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = vm.product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Divider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = Gray100
                )
                Text(
                    modifier = Modifier.padding(bottom = 7.dp),
                    text = "Descripcion",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = vm.product.description,
                    fontSize = 15.sp
                )
                Divider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = Gray100
                )
                Text(
                    modifier = Modifier.padding(bottom = 7.dp),
                    text = "Precio",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = vm.product.price.toString(),
                    fontSize = 15.sp
                )
                Divider(
                    modifier = Modifier.padding(vertical = 10.dp),
                    color = Gray100
                )
                Text(
                    modifier = Modifier.padding(bottom = 7.dp),
                    text = "Tu orden",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Cantidad:",// ${vm.quantity}",
                    fontSize = 15.sp
                )
                Text(
                    text = "Precio c/u:",// ${vm.price}",
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier.width(110.dp).height(40.dp),
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
                                modifier = Modifier.clickable{ vm.remove() },
                                text = "-",
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = vm.quantity.toString(),
                                fontSize = 18.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                modifier = Modifier.clickable{ vm.add() },
                                text = "+",
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    DefaultButton(
                        modifier = Modifier.width(170.dp),
                        text = "AGREGAR",
                        onClick = { vm.saveItem() }
                    )
                }
            }
        }
    }

    LaunchedEffect(key1 = state.currentPage){
        delay(10000)
        var newPosition = state.currentPage + 1
        if(newPosition > vm.productImages.size - 1) newPosition = 0
        state.animateScrollToPage(newPosition)
    }
}