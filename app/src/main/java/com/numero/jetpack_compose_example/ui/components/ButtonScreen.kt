package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.FlexColumn
import androidx.ui.layout.HeightSpacer
import androidx.ui.layout.Padding
import androidx.ui.material.Button
import androidx.ui.material.ContainedButtonStyle
import androidx.ui.material.OutlinedButtonStyle
import androidx.ui.material.TextButtonStyle
import com.numero.jetpack_compose_example.core.widget.Toolbar
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun ButtonScreen() {
    FlexColumn {
        inflexible {
            Toolbar(
                    title = "Button",
                    isShowArrowBack = true,
                    onBackPressed = {
                        // TODO implement back press
                        navigateTo(Screen.Home)
                    }
            )
        }
        expanded(1.0f) {
            ButtonContent()
        }
    }
}

@Composable
private fun ButtonContent() {
    VerticalScroller {
        Padding(padding = 16.dp) {
            Column {
                Button(
                        text = "ContainedButton",
                        onClick = {
                        },
                        style = ContainedButtonStyle()
                )
                HeightSpacer(32.dp)
                Button(
                        text = "OutlinedButton",
                        onClick = {
                        },
                        style = OutlinedButtonStyle()
                )
                HeightSpacer(32.dp)
                Button(
                        text = "TextButton",
                        onClick = {
                        },
                        style = TextButtonStyle()
                )
            }
        }
    }
}