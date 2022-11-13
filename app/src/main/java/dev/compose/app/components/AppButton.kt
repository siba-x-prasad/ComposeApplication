package dev.compose.app.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(
    title: String = "Hello", buttonColor: Color = Color.Red, textColor: Color = Color.White,
    enabled: Boolean = true, onClick: (() -> Unit), radious: Int = 8
) {

    val color = remember { mutableStateOf(Color.Red) }

    Button(
        onClick = onClick,
//        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(radious.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = color.value,
            contentColor = textColor
        ),
        modifier = Modifier
            .padding(8.dp)
        /*.pointerInteropFilter {
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    color.value = teal700
                }

                MotionEvent.ACTION_UP -> {
                    color.value = teal200
                }
            }
            true
        }*/
    ) {
        Text(color = textColor, text = title)
    }
}