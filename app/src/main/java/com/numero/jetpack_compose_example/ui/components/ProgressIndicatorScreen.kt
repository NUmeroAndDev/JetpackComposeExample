package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.ui.core.dp
import androidx.ui.layout.Center
import androidx.ui.layout.Column
import androidx.ui.layout.HeightSpacer
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.material.LinearProgressIndicator

@Composable
fun ProgressIndicatorScreen() {
    Center {
        Column {
            CircularProgressIndicator()
            HeightSpacer(32.dp)
            LinearProgressIndicator()
        }
    }
}