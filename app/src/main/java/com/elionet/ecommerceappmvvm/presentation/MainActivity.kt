package com.elionet.ecommerceappmvvm.presentation

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.elionet.ecommerceappmvvm.presentation.navigation.graph.root.RootNavGraph
import com.elionet.ecommerceappmvvm.ui.theme.KotlinEcommerceMVVMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("ContextCastToActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinEcommerceMVVMTheme {

                val navController = rememberNavController()
                val activity = LocalContext.current  as? Activity
                val deepLink = remember { mutableStateOf(activity?.intent?.data) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    navController = rememberNavController()
                    RootNavGraph(navController = navController)
                }
            }
        }
    }
}
