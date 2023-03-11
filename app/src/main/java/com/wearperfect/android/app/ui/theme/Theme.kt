package com.wearperfect.android.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val DarkColorPalette = darkColors(
    primary = PrimaryWhite,
    primaryVariant = SecondaryWhite,
    secondary = BaseThemeColor,
    background = PrimaryDark,
    onBackground = PrimaryWhite,

    /*primary = PrimaryDark,
    primaryVariant = SecondaryDark,
    secondary = Teal200,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black*/

    /* Other default colors to override
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    */
)

private val LightColorPalette = lightColors(
    primary = PrimaryDark,
    primaryVariant = SecondaryDark,
    secondary = BaseThemeColor,
    background = PrimaryWhite,
    onBackground = PrimaryDark,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun WearperfectAndroidAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        //typography = Typography,
        shapes = Shapes,
        content = content
    )
}

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        //fontFamily = OpenSansFamily,
        //fontWeight = FontWeight.Light,
        fontSize = 96.sp,
        letterSpacing = (-1.5).sp
    ),
    h2 = TextStyle(
        //fontFamily = OpenSansFamily,
        //fontWeight = FontWeight.Light,
        fontSize = 60.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        //fontFamily = OpenSansFamily,
        //fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        letterSpacing = 0.sp
    ),
    h4 = TextStyle(
        //fontFamily = OpenSansFamily,
        //fontWeight = FontWeight.Normal,
        fontSize = 34.sp,
        letterSpacing = 0.25.sp
    ),
    h5 = TextStyle(
        //fontFamily = OpenSansFamily,
        //fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        letterSpacing = 0.sp
    ),
    h6 = TextStyle(
        //fontFamily = OpenSansFamily,
        //fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle1 = TextStyle(
        //fontFamily = OpenSansFamily,
        //fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle2 = TextStyle(
        //fontFamily = OpenSansFamily,
        //fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp
    ),
    body1 = TextStyle(
        //fontFamily = OpenSansFamily,
        //fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    ),
    body2 = TextStyle(
        //fontFamily = OpenSansFamily,
        //fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),
    button = TextStyle(
        //fontFamily = OpenSansFamily,
        //fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 1.25.sp
    ),
    caption = TextStyle(
        //fontFamily = OpenSansFamily,
        //fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp
    ),
    overline = TextStyle(
        //fontFamily = OpenSansFamily,
        //fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        letterSpacing = 1.5.sp
    )
)
