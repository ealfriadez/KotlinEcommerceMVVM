package com.elionet.ecommerceappmvvm.presentation.screens.profile.update.components

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil.compose.AsyncImage
import com.elionet.ecommerceappmvvm.R
import com.elionet.ecommerceappmvvm.presentation.components.DefaultButton
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTextField
import com.elionet.ecommerceappmvvm.presentation.screens.profile.update.ProfileUpdateViewModel

@Composable
fun ProfileUpdateContent(paddingValues: PaddingValues, vm: ProfileUpdateViewModel = hiltViewModel()){
      val activity = LocalContext.current as? Activity

    Box(modifier = Modifier
        .padding(paddingValues = paddingValues)
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

        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(25.dp))
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
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = { },
                        label = "Nombres",
                        icon = Icons.Default.Person
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = { },
                        label = "Apellidos",
                        icon = Icons.Outlined.Person
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = { },
                        label = "Telefono",
                        icon = Icons.Default.Phone
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = "Confirmar",
                        onClick = { /*TODO*/ }
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}