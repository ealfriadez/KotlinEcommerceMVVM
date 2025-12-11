package com.elionet.ecommerceappmvvm.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import com.elionet.ecommerceappmvvm.ui.theme.AccentColor

@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String,
    icon: ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text
){
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = {text ->
            onValueChange(text)
        },
        label = {
            Text(text = label)
                },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = AccentColor
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}