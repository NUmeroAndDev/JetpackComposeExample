package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.layout.Center
import androidx.ui.material.AlertDialog
import androidx.ui.material.Button

@Composable
fun AlertDialogScreen() {
    var isShowProgress by +state { false }
    Center {
        Button(
            text = "Show Alert Dialog",
            onClick = {
                isShowProgress = true
            }
        )
    }
    if (isShowProgress) {
        AlertDialog(
            onCloseRequest = {
                isShowProgress = false
            },
            title = {
                Text("Title")
            },
            text = {
                Text("Message")
            },
            confirmButton = {
                Button(
                    text = "OK",
                    onClick = {
                        isShowProgress = false
                    }
                )
            }
        )
    }
}