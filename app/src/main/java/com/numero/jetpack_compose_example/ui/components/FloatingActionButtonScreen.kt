package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Scaffold
import androidx.ui.res.stringResource
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import com.numero.jetpack_compose_example.R
import com.numero.jetpack_compose_example.core.widget.Toolbar
import com.numero.jetpack_compose_example.core.widget.VectorImage
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun FloatingActionButtonScreen() {
    Scaffold(
            topAppBar = {
                Toolbar(
                        title = "FloatingActionButton",
                        isShowArrowBack = true,
                        onBackPressed = {
                            // TODO implement back press
                            navigateTo(Screen.Home)
                        }
                )
            },
            bodyContent = {
                FloatingActionButtonContent()
            }
    )
}

@Composable
private fun FloatingActionButtonContent() {
    val longText = stringResource(R.string.large_text)
    val color = MaterialTheme.colors()

    Stack(modifier = LayoutWidth.Fill + LayoutHeight.Fill) {
        VerticalScroller(modifier = LayoutGravity.Stretch) {
            Padding(16.dp) {
                Text(
                        text = longText,
                        style = TextStyle(
                                color = color.onBackground
                        )
                )
            }
        }
        Column(modifier = LayoutGravity.BottomRight) {
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