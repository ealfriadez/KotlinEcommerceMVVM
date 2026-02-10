package com.elionet.ecommerceappmvvm.presentation.screens.profile.info.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.elionet.ecommerceappmvvm.R
import com.elionet.ecommerceappmvvm.presentation.MainActivity
import com.elionet.ecommerceappmvvm.presentation.components.DefaultButton
import com.elionet.ecommerceappmvvm.presentation.navigation.Graph
import com.elionet.ecommerceappmvvm.presentation.screens.profile.info.ProfileViewModel
import java.net.URLEncoder

@Composable
fun ProfileContent(paddingValues: PaddingValues, vm: ProfileViewModel = hiltViewModel(), navController: NavHostController){
      val activity = LocalContext.current as? Activity

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .padding(bottom = 80.dp)
        .fillMaxSize()
    ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.profile_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale(
                        redScale = 0.6f,
                        greenScale = 0.6f,
                        blueScale = 0.6f,
                        alphaScale = 1f
                    )
                }
            )
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 15.dp, top = 15.dp),
                onClick = {
                    vm.logout()
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }
            ) {
                Image(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(id = R.drawable.logout),
                    contentDescription = ""
                )
            }
            IconButton(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 15.dp, top = 0.dp),
                onClick = {
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }
            ) {
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "",
                    tint = Color.White
                )
            }
            if (!vm.user?.image.isNullOrBlank()) {
                AsyncImage(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    model = vm.user?.image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }else{
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.user_image),
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.7f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 20.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = ""
                        )
                        Column(
                            modifier = Modifier.padding(horizontal = 5.dp)
                        ) {
                            Text(text = "${vm.user?.name} ${vm.user?.lastname}")
                            Text(
                                text = "Nombre de usuario",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = ""
                        )
                        Column(
                            modifier = Modifier.padding(horizontal = 5.dp)
                        ) {
                            Text(text = "${vm.user?.email}")
                            Text(
                                text = "Correo de usuario",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = ""
                        )
                        Column(
                            modifier = Modifier.padding(horizontal = 5.dp)
                        ) {
                            Text(text = vm.user?.phone ?: "")
                            Text(
                                text = "Telefono de usuario",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "Actualizar informacion",
                        /*onClick = {
                            navController.navigate(route = "${Graph.PROFILE}/${vm.user?.toJson()}")
                        }*/
                        onClick = {
                            // 1. Obtenemos el JSON
                            val userJson = vm.user?.toJson()

                            // 2. Lo codificamos para que sea seguro viajar en la ruta
                            // Importa java.net.URLEncoder
                            val encodedJson = URLEncoder.encode(userJson, "UTF-8")

                            // 3. Navegamos con el JSON codificado
                            navController.navigate(route = "${Graph.PROFILE}/$encodedJson")
                        }
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}