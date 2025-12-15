package com.elionet.ecommerceappmvvm.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.elionet.ecommerceappmvvm.R
import com.elionet.ecommerceappmvvm.presentation.components.DefaultButton
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTextField
import com.elionet.ecommerceappmvvm.presentation.navigation.screen.AuthScreen
import com.elionet.ecommerceappmvvm.presentation.screens.auth.login.LoginViewModel
import com.elionet.ecommerceappmvvm.ui.theme.AccentColor

@Composable
fun LoginContent(
    navController: NavHostController,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier.fillMaxSize(),
    vm: LoginViewModel = hiltViewModel()
){

    val state = vm.state
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage) {
        if (vm.errorMessage != "") {
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_LONG).show()
        }
    }

    Box(modifier = Modifier) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.banner),
            contentDescription =  "Imagen de fondo",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(
                        redScale = 0.5f,
                        greenScale = 0.5f,
                        blueScale = 0.5f,
                        alphaScale = 1f
                    )
                }
            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(R.drawable.shopping_cart_blue),
                contentDescription =  "Logo"
            )
            Text(
                modifier = Modifier.padding(top = 10.dp),
                fontWeight = FontWeight.Bold,
                text = "ECOMMERCE APP",
                color = Color.White,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ), colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.89f)
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 30.dp, end = 30.dp, start = 30.dp)
                        .verticalScroll(rememberScrollState())
                )  {
                    Text(
                        modifier = Modifier.padding(20.dp),
                        text = "INGRESAR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange = { text ->
                            vm.onEmailInput(text)
                        },
                        label = "Correo Electrónico",
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.password,
                        onValueChange = { text ->
                            vm.onPasswordInput(text)
                        },
                        label = "Contraseña",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(top = 10.dp),
                        onClick = { vm.validateForm() },
                        text = "INICIAR SESIÓN"
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp, bottom = 20.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "¿No tienes una cuenta?",
                            color = Color.Black)
                        Text(
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .clickable {navController.navigate(route = AuthScreen.Register.route)} ,
                            text = "REGISTRATE",
                            fontWeight = FontWeight.Bold,
                            color = AccentColor
                        )
                    }
                }
            }
        }
    }
}