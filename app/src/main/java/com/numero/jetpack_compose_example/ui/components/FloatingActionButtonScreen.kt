package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.FlexColumn
import androidx.ui.layout.Padding
import androidx.ui.layout.Stack
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.res.stringResource
import androidx.ui.text.TextStyle
import com.numero.jetpack_compose_example.R
import com.numero.jetpack_compose_example.core.widget.VectorImage
import com.numero.jetpack_compose_example.core.widget.VectorImageButton
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun FloatingActionButtonScreen() {
    FlexColumn {
        inflexible {
            TopAppBar(
                    title = {
                        Text("FloatingActionButton")
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
            FloatingActionButtonContent()
        }
    }
}

@Composable
private fun FloatingActionButtonContent() {
    val longText = +stringResource(R.string.large_text)
    val color = (+MaterialTheme.colors())

    Stack {
        expanded {
            VerticalScroller {
                Padding(16.dp) {
                    Text(
                            text = longText,
                            style = TextStyle(
                                    color = color.onBackground
                            )
                    )
                }
            }
        }
        aligned(alignment = Alignment.BottomRight) {
            Padding(16.dp) {
                FloatingActionButton(
                        color = color.secondary,
                        onClick = {
                            // TODO click action
                        }
                ) {
                    VectorImage(
                            id = R.drawable.ic_add,
                            tint = color.onSecondary
                    )
                }
            }
        }
    }
}