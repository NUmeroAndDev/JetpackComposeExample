package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.unit.dp
import com.numero.jetpack_compose_example.core.widget.Toolbar
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun ButtonScreen() {
    Scaffold(
            topAppBar = {
                Toolbar(
                        title = "Button",
                        isShowArrowBack = true,
                        onBackPressed = {
                            // TODO implement back press
                            navigateTo(Screen.Home)
                        }
                )
            },
            bodyContent = {
                ButtonContent()
            }
    )
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
                Spacer(modifier = LayoutHeight(32.dp) + LayoutWidth.Fill)
                Button(
                        text = "OutlinedButton",
                        onClick = {
                        },
                        style = OutlinedButtonStyle()
                )
                Spacer(modifier = LayoutHeight(32.dp) + LayoutWidth.Fill)
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