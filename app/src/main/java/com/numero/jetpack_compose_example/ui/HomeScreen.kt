package com.numero.jetpack_compose_example.ui

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import com.numero.jetpack_compose_example.core.AppTheme
import com.numero.jetpack_compose_example.ui.components.ComponentDetailScreen
import com.numero.jetpack_compose_example.ui.components.ComponentScreen

@Composable
fun HomeScreen() {
    AppTheme {
        Surface(color = MaterialTheme.colors().background) {
            when (val screen = ScreenStatus.currentScreen) {
                is Screen.Home -> ComponentScreen()
                is Screen.ComponentDetail -> ComponentDetailScreen(
                    screen.component
                )
            }
        }
    }
}