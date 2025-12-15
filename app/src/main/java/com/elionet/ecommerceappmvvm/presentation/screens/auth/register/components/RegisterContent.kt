package com.elionet.ecommerceappmvvm.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Person
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.elionet.ecommerceappmvvm.R
import com.elionet.ecommerceappmvvm.presentation.components.DefaultButton
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTextField
import com.elionet.ecommerceappmvvm.presentation.screens.auth.register.RegisterViewModel

@Composable
fun RegisterContent(
    paddingValues: PaddingValues,
    vm: RegisterViewModel = hiltViewModel()
){

    val state = vm.state
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage) {
        if (vm.errorMessage != "") {
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_LONG).show()
        }
    }

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
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
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .padding(top = 20.dp),
                painter = painterResource(id = R.drawable.user_image),
                contentDescription = ""
            )
            Text(
                modifier = Modifier                    
                    .padding(top = 7.dp),
                text = "INGRESA ESTA INFORMACIÓN",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp
                ),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.8f))
            ) {
                Column(
                    modifier = Modifier.padding(
                        top = 30.dp,
                        end = 30.dp,
                        start = 30.dp,
                        bottom = 30.dp
                    ),
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "REGISTRARSE",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.name,
                        onValueChange = { text ->
                            vm.onNameInput(text)
                        },
                        label = "Nombres",
                        icon = Icons.Default.Person
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.lastName,
                        onValueChange = { text ->
                            vm.onLastNameInput(text)
                        },
                        label = "Apellidos",
                        icon = Icons.Outlined.Person
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange = { text ->
                            vm.onEmailInput(text)
                        },
                        label = "Correo electrónico",
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email
                    )

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.phone,
                        onValueChange = { text ->
                            vm.onPhoneInput(text)
                        },
                        label = "Teléfono",
                        icon = Icons.Default.Phone,
                        keyboardType = KeyboardType.Phone
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

                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.confirmPassword,
                        onValueChange = { text ->
                            vm.onConfirmPasswordInput(text)
                        },
                        label = "Confirmar contraseña",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        text = "CONFIRMAR",
                        onClick = {
                            vm.validateForm()
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview(){ }