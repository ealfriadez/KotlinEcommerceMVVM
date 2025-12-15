package com.elionet.ecommerceappmvvm.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.elionet.ecommerceappmvvm.ui.theme.AccentColor

@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String,
    icon: ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = false
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
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.LightGray,
            cursorColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Gray
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None

    )
}