package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Text
import androidx.ui.layout.Center
import androidx.ui.layout.FlexColumn
import androidx.ui.material.Button
import androidx.ui.material.DrawerState
import androidx.ui.material.ModalDrawerLayout
import com.numero.jetpack_compose_example.core.widget.Toolbar
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun DrawerScreen() {
    var state by state { DrawerState.Closed }
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
private fun DrawerContent() {
    Text("Drawer")
}

@Composable
private fun DrawerBodyContent(openDrawer: () -> Unit) {
    FlexColumn {
        inflexible {
            Toolbar(
                    title = "Drawer",
                    isShowArrowBack = true,
                    onBackPressed = {
                        // TODO implement back press
                        navigateTo(Screen.Home)
                    }
            )
        }
        expanded(1.0f) {
            Center {
                Button(
                        text = "Show drawer",
                        onClick = {
                            openDrawer()
                        }
                )
            }
        }
    }
}