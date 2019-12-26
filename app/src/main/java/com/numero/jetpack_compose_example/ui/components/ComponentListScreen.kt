package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.material.ListItem
import androidx.ui.material.TopAppBar
import com.numero.jetpack_compose_example.core.widget.AppBarLayout
import com.numero.jetpack_compose_example.model.Component
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun ComponentScreen() {
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

@Composable
fun ComponentList() {
    val componentList = Component.values().toList()
    VerticalScroller {
        Column {
            componentList.forEach { component ->
                ListItem(text = component.label) {
                    navigateTo(
                        Screen.ComponentDetail(
                            component
                        )
                    )
                }
            }
        }
    }
}