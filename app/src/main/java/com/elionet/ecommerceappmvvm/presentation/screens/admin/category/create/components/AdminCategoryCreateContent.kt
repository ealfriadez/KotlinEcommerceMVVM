package com.elionet.ecommerceappmvvm.presentation.screens.admin.category.create.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elionet.ecommerceappmvvm.R
import com.elionet.ecommerceappmvvm.presentation.components.DefaultButton
import com.elionet.ecommerceappmvvm.presentation.components.DefaultTextField

@Composable
fun AdminCategoryCreateContent(paddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))
        Image(
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.image_add),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(40.dp))

        Card(
            modifier = Modifier.fillMaxWidth().weight(1f),
            shape = RoundedCornerShape(
                topEnd = 40.dp,
                topStart = 40.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    modifier = Modifier.padding(bottom = 20.dp),
                    text = "CATEGORIA",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    onValueChange = { },
                    label = "Nombre de la categoria",
                    icon = Icons.Default.List
                )
                DefaultTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    onValueChange = { },
                    label = "Descripcion",
                    icon = Icons.Outlined.Info
                )
                Spacer(modifier = Modifier.weight(1f))
                DefaultButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Crear categoria",
                    onClick = { }
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}