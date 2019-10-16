package com.numero.jetpack_compose_example.core

import androidx.compose.Composable
import androidx.ui.layout.FlexColumn

@Composable
fun AppBarLayout(
    appBar: @Composable() () -> Unit,
    content: @Composable() () -> Unit
) {
    FlexColumn {
        inflexible { appBar() }
        expanded(1.0f) { content() }
    }
}