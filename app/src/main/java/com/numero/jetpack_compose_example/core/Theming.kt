package com.numero.jetpack_compose_example.core

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.foundation.isSystemInDarkTheme
import androidx.ui.foundation.shape.DrawShape
import androidx.ui.foundation.shape.RectangleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.Stack
import androidx.ui.material.ColorPalette
import androidx.ui.material.MaterialTheme

@Composable
fun AppTheme(
    children: @Composable() () -> Unit
) {
    val isDarkTheme = +isSystemInDarkTheme()
    MaterialTheme(
        colors = if (isDarkTheme) darkThemeColor else lightThemeColor,
        children = {
            /**
             * FIXME
             * If supported background color, remove this code.
             */
            Stack {
                expanded {
                    DrawShape(
                        shape = RectangleShape,
                        color = (+MaterialTheme.colors()).background
                    )
                }
                expanded {
                    children()
                }
            }
        }
    )
}

val lightThemeColor = ColorPalette(
    primary = Color("#6200EE"),
    primaryVariant = Color("#3700B3"),
    secondary = Color("#03DAD6"),
    secondaryVariant = Color("#018786"),
    background = Color("#FFFFFF"),
    surface = Color("#FFFFFF"),
    error = Color("#B00020"),
    onPrimary = Color("#FFFFFF"),
    onSecondary = Color("#000000"),
    onBackground = Color("#000000"),
    onSurface = Color("#000000"),
    onError = Color("#FFFFFF")
)

val darkThemeColor = ColorPalette(
    primary = Color("#BB86FC"),
    primaryVariant = Color("#3700B3"),
    secondary = Color("#03DAD6"),
    secondaryVariant = Color("#03DAD6"),
    background = Color("#121212"),
    surface = Color("#121212"),
    error = Color("#CF6679"),
    onPrimary = Color("#000000"),
    onSecondary = Color("#000000"),
    onBackground = Color("#FFFFFF"),
    onSurface = Color("#FFFFFF"),
    onError = Color("#000000")
)

fun Color(colorString: String): Color {
    return Color(android.graphics.Color.parseColor(colorString))
}