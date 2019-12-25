package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.material.Divider
import androidx.ui.material.ListItem

@Composable
fun ListScreen() {
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