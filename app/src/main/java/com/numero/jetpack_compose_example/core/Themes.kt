package com.numero.jetpack_compose_example.core

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.foundation.isSystemInDarkTheme
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface

@Composable
fun AppTheme(
    children: () -> Unit
) {
    val isDarkTheme = +isSystemInDarkTheme()
    MaterialTheme(
        colors = if (isDarkTheme) darkThemeColor else lightThemeColor
    ) {
        children()
    }
}