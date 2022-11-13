package dev.compose.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import dev.compose.app.R
import dev.compose.app.ui.theme.ComposeApplicationTheme
import dev.compose.app.ui.theme.Fonts.fontFamily
import dev.compose.app.ui.theme.Fonts.robotoBold

@Composable
fun OnBoardingScreen(
    navigateToLogin: () -> Unit,
    navigateToRegistration: () -> Unit,
) {
    val context = LocalContext.current
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        // Create references for the composable to constrain
        val (buttonLogin, buttonRegister, title, loginWith, imageRow, login) = createRefs()

        Text(
            "Welcome To Compose App",
            color = Color.Black,
            fontSize = 30.sp,
            fontFamily = fontFamily,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Text(
            "Login Using",
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = robotoBold,
            modifier = Modifier
                .constrainAs(loginWith) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(0.dp, 20.dp, 0.dp, 0.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(imageRow) {
                    top.linkTo(loginWith.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(0.dp, 20.dp, 0.dp, 0.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google Login",
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .padding(5.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "Facebook Login",
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .padding(5.dp)
            )
        }

        Text(
            "Or Login",
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = robotoBold,
            modifier = Modifier
                .constrainAs(login) {
                    bottom.linkTo(buttonLogin.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(0.dp, 20.dp, 0.dp, 0.dp)
        )

        Button(
            onClick = navigateToLogin,
            modifier = Modifier
                .constrainAs(buttonLogin) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    horizontalChainWeight = 1f
                }
                .fillMaxWidth(0.5f)
                .padding(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Login")
        }

        Button(
            onClick = navigateToRegistration,
            modifier = Modifier
                .constrainAs(buttonRegister) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(0.5f)
                .padding(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Register")
        }
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
            OnBoardingScreen(
                navigateToLogin = {},
                navigateToRegistration = {}
            )
        }
    }
}