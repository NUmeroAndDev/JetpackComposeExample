package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Text
import androidx.ui.layout.*
import androidx.ui.material.Slider
import androidx.ui.material.SliderPosition
import androidx.ui.unit.dp
import com.numero.jetpack_compose_example.core.widget.Toolbar
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun SliderScreen() {
    FlexColumn {
        inflexible {
            Toolbar(
                    title = "Slider",
                    isShowArrowBack = true,
                    onBackPressed = {
                        // TODO implement back press
                        navigateTo(Screen.Home)
                    }
            )
        }
        expanded(1.0f) {
            SliderContent()
        }
    }
}

@Composable
private fun SliderContent() {
    val sliderPosition by state {
        SliderPosition(
                valueRange = 0f..10f,
                steps = 10
        )
    }

    Center {
        Padding(padding = 16.dp) {
            Column {
                Text("${sliderPosition.value}")
                Spacer(modifier = LayoutHeight(32.dp) + LayoutWidth.Fill)
                Slider(
                        position = sliderPosition
                )
            }
        }
    }
}