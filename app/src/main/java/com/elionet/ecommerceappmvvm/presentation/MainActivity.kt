package com.elionet.ecommerceappmvvm.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.elionet.ecommerceappmvvm.presentation.navigation.graph.RootNavGraph
import com.elionet.ecommerceappmvvm.ui.theme.KotlinEcommerceMVVMTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinEcommerceMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    navController = rememberNavController()
                    RootNavGraph(navController = navController)
                }
            }
        }
    }
}
