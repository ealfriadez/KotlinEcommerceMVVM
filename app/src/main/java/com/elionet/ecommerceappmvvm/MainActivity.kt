package com.elionet.ecommerceappmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elionet.ecommerceappmvvm.ui.theme.KotlinEcommerceMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            KotlinEcommerceMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginContent(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginContent(modifier: Modifier = Modifier.fillMaxSize()){
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
            modifier = Modifier.fillMaxWidth().padding(top = 50.dp),
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
                    containerColor = Color.White // Este es el parámetro correcto para el color de fondo
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                )  {
                    Text(
                        modifier = Modifier.padding(20.dp),
                        text = "INGRESAR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = { Text(text = "Correo electrónico") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Correo electrónico",
                                tint = Color.Cyan
                            )
                        },
                        colors = TextFieldDefaults.colors( // La función se llama solo 'colors'
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                            // O usa containerColor, dependiendo de la variante de TextField que uses
                        )
                    )
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = { Text(text = "Contraseña") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Lock",
                                tint = Color.Cyan
                            )
                        },
                        colors = TextFieldDefaults.colors( // La función se llama solo 'colors'
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                            // O usa containerColor, dependiendo de la variante de TextField que uses
                        )
                    )
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Cyan, // El color de fondo del botón
                            contentColor = Color.Black    // El color del texto o contenido (LOGIN)
                        ),
                        onClick = {}) {
                        Text(
                            text = "LOGIN",
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "¿No tienes una cuenta?",
                            color = Color.Black)
                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = "REGISTRATE",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    KotlinEcommerceMVVMTheme {
        Greeting("Android")
    }
}