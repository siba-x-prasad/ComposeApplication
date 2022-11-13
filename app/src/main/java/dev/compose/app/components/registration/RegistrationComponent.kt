package dev.compose.app.components.registration

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.compose.app.components.AppButton
import dev.compose.app.components.OutLineTextField
import dev.compose.app.ui.theme.ComposeApplicationTheme


@Composable
fun RegistrationScreen(navigateToLogin: () -> Unit, navigateToHome: () -> Unit) {

    val context = LocalContext.current

    var nameText by remember { mutableStateOf("") }
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    var mobileText by remember { mutableStateOf("") }
    var addressText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutLineTextField(
            hint = "Name",
            defaultValue = nameText,
            onTextChange = { newText -> nameText = newText }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutLineTextField(
            hint = "Email Id",
            defaultValue = emailText,
            onTextChange = { newText -> emailText = newText }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutLineTextField(
            hint = "Mobile Number",
            defaultValue = mobileText,
            onTextChange = { newText -> mobileText = newText },
            inputType = KeyboardType.Decimal
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutLineTextField(
            hint = "Address",
            defaultValue = addressText,
            onTextChange = { newText -> addressText = newText },
            inputType = KeyboardType.Text,
            modifier = Modifier
                .height(100.dp)
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutLineTextField(
            hint = "Password",
            defaultValue = passwordText,
            onTextChange = { newText -> passwordText = newText },
            inputType = KeyboardType.Password
        )
        Spacer(modifier = Modifier.height(20.dp))
        AppButton(title = "Register", onClick = navigateToHome)
        AppButton(title = "Already Have Account ? Login ", onClick = navigateToLogin)
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    ComposeApplicationTheme(darkTheme = false) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            RegistrationScreen(
                navigateToLogin = {},
                navigateToHome = {}
            )
        }
    }
}