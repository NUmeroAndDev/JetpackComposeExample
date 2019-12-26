package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Slider
import androidx.ui.material.SliderPosition
import androidx.ui.material.TopAppBar
import com.numero.jetpack_compose_example.R
import com.numero.jetpack_compose_example.core.widget.VectorImageButton
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun SliderScreen() {
    FlexColumn {
        inflexible {
            TopAppBar(
                    title = {
                        Text("Slider")
                    },
                    navigationIcon = {
                        VectorImageButton(
                                id = R.drawable.ic_arrow_back,
                                tint = (+MaterialTheme.colors()).onPrimary
                        ) {
                            // TODO implement back press
                            navigateTo(Screen.Home)
                        }
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