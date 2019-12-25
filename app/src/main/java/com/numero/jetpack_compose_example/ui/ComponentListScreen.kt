package com.numero.jetpack_compose_example.ui

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.material.ListItem
import androidx.ui.material.TopAppBar
import com.numero.jetpack_compose_example.core.AppBarLayout
import com.numero.jetpack_compose_example.core.AppTheme
import com.numero.jetpack_compose_example.model.Component

@Composable
fun ComponentScreen() {
    AppTheme {
        AppBarLayout(
            appBar = {
                TopAppBar(
                    title = {
                        Text("Jetpack Compose Example")
                    }
                )
            },
            content = {
                ComponentList()
            }
        )
    }
}

@Composable
fun ComponentList() {
    val componentList = Component.values().toList()
    VerticalScroller {
        Column {
            componentList.forEach { component ->
                ListItem(text = component.label) {
                    // TODO clicked component
                }
            }
        }
    }
}