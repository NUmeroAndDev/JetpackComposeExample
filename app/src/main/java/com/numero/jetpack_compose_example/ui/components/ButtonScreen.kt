package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.HeightSpacer
import androidx.ui.layout.Padding
import androidx.ui.material.Button
import androidx.ui.material.ContainedButtonStyle
import androidx.ui.material.OutlinedButtonStyle
import androidx.ui.material.TextButtonStyle

@Composable
fun ButtonScreen() {
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
