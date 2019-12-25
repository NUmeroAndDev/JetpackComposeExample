package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Padding
import androidx.ui.layout.Stack
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.MaterialTheme
import androidx.ui.res.stringResource
import androidx.ui.text.TextStyle
import com.numero.jetpack_compose_example.R
import com.numero.jetpack_compose_example.core.VectorImage

@Composable
fun FloatingActionButtonScreen() {
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