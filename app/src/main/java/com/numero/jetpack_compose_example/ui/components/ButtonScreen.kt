package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.FlexColumn
import androidx.ui.layout.HeightSpacer
import androidx.ui.layout.Padding
import androidx.ui.material.*
import com.numero.jetpack_compose_example.R
import com.numero.jetpack_compose_example.core.widget.VectorImageButton
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun ButtonScreen() {
    FlexColumn {
        inflexible {
            TopAppBar(
                    title = {
                        Text("Button")
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