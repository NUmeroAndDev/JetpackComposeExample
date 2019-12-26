package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.layout.Center
import androidx.ui.layout.FlexColumn
import androidx.ui.material.*
import com.numero.jetpack_compose_example.R
import com.numero.jetpack_compose_example.core.VectorImageButton
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

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
private fun DrawerContent() {
    Text("Drawer")
}

@Composable
private fun DrawerBodyContent(openDrawer: () -> Unit) {
    FlexColumn {
        inflexible {
            TopAppBar(
                    title = {
                        Text("Drawer")
                    },
                    navigationIcon = {
                        VectorImageButton(
                                id = R.drawable.ic_arrow_back,
                                tint = (+MaterialTheme.colors()).onPrimary
                        ) {
                            // TODO implement back press
                            navigateTo(Screen.Home)
                        }
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