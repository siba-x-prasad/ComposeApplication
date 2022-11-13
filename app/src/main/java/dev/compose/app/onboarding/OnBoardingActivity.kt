package dev.compose.app.onboarding

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import dev.compose.app.R
import dev.compose.app.nav.NavGraph
import dev.compose.app.ui.theme.ComposeApplicationTheme

class OnBoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
private fun MainScreen() {
    ComposeApplicationTheme() {
        val navController = rememberNavController()
        NavGraph(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnBoard() {
    val context: Context = LocalContext.current
    val navController: NavController = rememberNavController()
    val title: String = "On Boarding"
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title, color = Color.White) },
                navigationIcon = {
                    Image(
                        painter = painterResource(R.drawable.ic_baseline_electric_bike_24),
                        contentDescription = "Icon"
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Black)
            )
        }
    ) {
        it
    }
    Box() {

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeApplicationTheme {
        Greeting("Android")
    }
}