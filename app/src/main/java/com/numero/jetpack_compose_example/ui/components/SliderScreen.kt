package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.material.LinearProgressIndicator
import androidx.ui.material.Slider
import androidx.ui.material.SliderPosition

@Composable
fun SliderScreen() {
    val sliderPosition by +state {
        SliderPosition(
            valueRange = 0f..10f,
            steps = 10
        )
    }

    Center {
        Padding(padding = 16.dp) {
            Column {
                Text("${sliderPosition.value}")
                HeightSpacer(height = 32.dp)
                Slider(
                    position = sliderPosition
                )
            }
        }
    }
}