package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.layout.Center
import androidx.ui.layout.FlexColumn
import androidx.ui.material.AlertDialog
import androidx.ui.material.Button
import com.numero.jetpack_compose_example.core.widget.Toolbar
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun AlertDialogScreen() {
    FlexColumn {
        inflexible {
            Toolbar(
                    title = "AlertDialog",
                    isShowArrowBack = true,
                    onBackPressed = {
                        // TODO implement back press
                        navigateTo(Screen.Home)
                    }
            )
        }
        expanded(1.0f) {
            AlertDialogContent()
        }
    }
}

@Composable
private fun AlertDialogContent() {
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