package com.numero.jetpack_compose_example.core.widget

import androidx.compose.Composable
import androidx.ui.material.Scaffold

@Composable
fun AppBarLayout(
        appBar: @Composable() () -> Unit,
        content: @Composable() () -> Unit
) {
    Scaffold(
            topAppBar = {
                appBar()
            },
            bodyContent = {
                content()
            }
    )
}