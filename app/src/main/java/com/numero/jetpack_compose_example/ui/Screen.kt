package com.numero.jetpack_compose_example.ui

import androidx.compose.Model
import com.numero.jetpack_compose_example.model.Component

sealed class Screen {
    object Home : Screen()

    data class ComponentDetail(
        val component: Component
    ) : Screen()
}

@Model
object ScreenStatus {
    var currentScreen: Screen = Screen.Home
}

fun navigateTo(destination: Screen) {
    ScreenStatus.currentScreen = destination
}