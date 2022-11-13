package dev.compose.app.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import dev.compose.app.R

object Fonts {
    val fontFamily = FontFamily(
        Font(R.font.roboto_regular, FontWeight.Thin),
        Font(R.font.robot_thin, FontWeight.Normal),
        Font(R.font.roboto_medium, FontWeight.Light),
        Font(R.font.roboto_light, FontWeight.ExtraLight),
        Font(R.font.roboto_italic, FontWeight.ExtraBold),
        Font(R.font.roboto_bold_italic, FontWeight.SemiBold),
        Font(R.font.roboto_bold, FontWeight.Thin),
        Font(R.font.roboto_light_italic, FontWeight.Medium),
        Font(R.font.roboto_thin_italic, FontWeight.Bold)
    )

    val robotoBold = FontFamily(
        Font(R.font.roboto_bold, FontWeight.Bold)
    )
}