package com.elionet.ecommerceappmvvm.presentation

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ComponentCaller
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.compose.rememberNavController
import com.elionet.ecommerceappmvvm.presentation.navigation.Graph
import com.elionet.ecommerceappmvvm.presentation.navigation.graph.root.RootNavGraph
import com.elionet.ecommerceappmvvm.ui.theme.KotlinEcommerceMVVMTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onNewIntent(intent: Intent, caller: ComponentCaller) {
        super.onNewIntent(intent, caller)
        setIntent(intent)
    }

    @SuppressLint("ContextCastToActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinEcommerceMVVMTheme {
                val navController = rememberNavController()
                val activity = LocalContext.current  as? Activity
                val deepLinkUri = remember { mutableStateOf(activity?.intent?.data) }
                val lifeCycleOwner = LocalLifecycleOwner.current

                DisposableEffect(Unit){
                    val observer = object: DefaultLifecycleObserver{
                        override fun onResume(owner: LifecycleOwner) {
                            deepLinkUri.value = activity?.intent?.data
                        }
                    }
                    lifeCycleOwner.lifecycle.addObserver(observer)
                    onDispose {
                        lifeCycleOwner.lifecycle.removeObserver(observer)
                    }
                }
                LaunchedEffect(deepLinkUri.value) {
                    deepLinkUri.value.let { uri ->
                        if(uri.toString().contains("payment/success")){
                            navController.navigate(Graph.CLIENT)
                            activity?.intent?.data = null
                        }
                    }
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //navController = rememberNavController()
                    RootNavGraph(navController = navController)
                }
            }
        }
    }
}
