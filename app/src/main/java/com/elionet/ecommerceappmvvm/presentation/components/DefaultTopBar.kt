package com.elionet.ecommerceappmvvm.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.client.ShoppingBagScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    title: String,
    upAvailable: Boolean = false,
    navController: NavHostController? = null,
    enableActions: Boolean = false
){
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White
        ),
        navigationIcon = {
            if (upAvailable) {
                IconButton(onClick = {navController?.popBackStack()}) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
            }
        },
        actions = {
            if(enableActions){
                IconButton(onClick = {navController?.navigate(route = ShoppingBagScreen.ShoppingBag.route)}) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
            }
        }
    )
}

