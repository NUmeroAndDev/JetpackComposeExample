package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.material.Divider
import androidx.ui.material.ListItem
import androidx.ui.material.Scaffold
import androidx.ui.unit.dp
import com.numero.jetpack_compose_example.core.widget.Toolbar
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun ListScreen() {
    Scaffold(
            topAppBar = {
                Toolbar(
                        title = "List",
                        isShowArrowBack = true,
                        onBackPressed = {
                            // TODO implement back press
                            navigateTo(Screen.Home)
                        }
                )
            },
            bodyContent = {
                ListContent()
            }
    )
}

@Composable
private fun ListContent() {
    VerticalScroller {
        Column {
            (0..5).forEachIndexed { index, _ ->
                ListItem(
                        text = "OneLineItem $index",
                        onClick = {
                        }
                )
                Divider(color = Color.LightGray, height = 1.dp)
            }
            (0..5).forEachIndexed { index, _ ->
                ListItem(
                        text = "TwoLineItem $index",
                        secondaryText = "SecondaryText",
                        onClick = {
                        }
                )
                Divider(color = Color.LightGray, height = 1.dp)
            }
            (0..5).forEachIndexed { index, _ ->
                ListItem(
                        text = "ThreeLineItem $index",
                        secondaryText = "SecondaryText",
                        overlineText = "OverlineText",
                        metaText = "MetaText",
                        onClick = {
                        }
                )
                Divider(color = Color.LightGray, height = 1.dp)
            }
        }
    }
}