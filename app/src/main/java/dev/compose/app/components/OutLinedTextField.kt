package dev.compose.app.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutLineTextField(
    defaultValue: String = "",
    hint: String,
    inputType: KeyboardType = KeyboardType.Text,
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit
) {
    OutlinedTextField(
        value = defaultValue,
        keyboardOptions = KeyboardOptions(keyboardType = inputType),
        label = { Text(text = hint) },
        onValueChange = onTextChange,
        modifier = modifier
    )
}