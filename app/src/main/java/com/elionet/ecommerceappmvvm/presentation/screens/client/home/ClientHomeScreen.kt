package com.elionet.ecommerceappmvvm.presentation.screens.client.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.elionet.ecommerceappmvvm.presentation.navigation.graph.client.ClientNavGraph
import com.elionet.ecommerceappmvvm.presentation.screens.client.home.components.ClientBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClientHomeScreen(navController: NavHostController = rememberNavController()){
    Scaffold(
        bottomBar = {
            ClientBottomBar(navController = navController)
        }
    ) { paddingValues ->
        ClientNavGraph(navController = navController)
        Text(
            modifier = Modifier.padding(paddingValues = paddingValues),
            text = ""
        )
    }
}