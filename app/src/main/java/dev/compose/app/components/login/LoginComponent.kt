package dev.compose.app.components.login

import android.widget.Toast
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
fun LoginScreen(navigateToHome: () -> Unit, navigateToRegistration: () -> Unit) {

    val context = LocalContext.current
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

    fun navLogin(): () -> Unit {
        Toast.makeText(
            context,
            "Email is $emailText Password  : $passwordText",
            Toast.LENGTH_SHORT
        ).show()
        return navigateToHome
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutLineTextField(hint = "Email Id",
            defaultValue = emailText,
            onTextChange = { newText ->
                emailText = newText
            }
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutLineTextField(
            hint = "Password",
            defaultValue = passwordText,
            onTextChange = { newText ->
                passwordText = newText
            },
            inputType = KeyboardType.Password
        )
        AppButton(title = "Login", onClick = navigateToHome)

        AppButton(title = "Dont have Account ? Register", onClick = navigateToRegistration)
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
            LoginScreen(
                navigateToHome = {},
                navigateToRegistration = {}
            )
        }
    }
}