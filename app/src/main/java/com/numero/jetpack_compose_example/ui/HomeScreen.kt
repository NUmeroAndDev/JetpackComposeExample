package com.numero.jetpack_compose_example.ui

import androidx.compose.Composable
import com.numero.jetpack_compose_example.core.AppTheme

@Composable
fun HomeScreen() {
    AppTheme {
        when (val screen = ScreenStatus.currentScreen) {
            is Screen.Home -> ComponentScreen()
            is Screen.ComponentDetail -> ComponentDetailScreen(screen.component)
        }
    }
}