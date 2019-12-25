package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.State
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.layout.Center
import androidx.ui.layout.Column
import androidx.ui.material.Button
import androidx.ui.material.DrawerState
import androidx.ui.material.ModalDrawerLayout

@Composable
fun DrawerScreen() {
    var state by +state { DrawerState.Closed }
    ModalDrawerLayout(
        drawerState = state,
        onStateChange = {
            if (state != it) {
                state = it
            }
        },
        drawerContent = {
            DrawerContent()
        },
        bodyContent = {
            DrawerBodyContent {
                state = DrawerState.Opened
            }
        }
    )
}

@Composable
fun DrawerContent() {
    Text("Drawer")
}

@Composable
fun DrawerBodyContent(openDrawer: () -> Unit) {
    Center {
        Button(
            text = "Show drawer",
            onClick = {
                openDrawer()
            }
        )
    }
}