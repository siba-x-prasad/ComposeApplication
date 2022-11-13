package dev.compose.app.components


import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ForgotPasswordScreen(navigateToLogin: () -> Unit) {

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutLineTextField(hint = "Email Id", onTextChange = {})
        Spacer(modifier = Modifier.height(20.dp))
        AppButton(title = "Reset Password", onClick = {
            Toast.makeText(context, "Login Clicked", Toast.LENGTH_SHORT).show()
        })

        AppButton(title = "Back to Home", onClick = navigateToLogin)
    }
}

