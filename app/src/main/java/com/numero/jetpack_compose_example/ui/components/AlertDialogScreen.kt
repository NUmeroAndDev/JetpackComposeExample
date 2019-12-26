package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.layout.Center
import androidx.ui.layout.FlexColumn
import androidx.ui.material.AlertDialog
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import com.numero.jetpack_compose_example.R
import com.numero.jetpack_compose_example.core.widget.VectorImageButton
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun AlertDialogScreen() {
    FlexColumn {
        inflexible {
            TopAppBar(
                    title = {
                        Text("AlertDialog")
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