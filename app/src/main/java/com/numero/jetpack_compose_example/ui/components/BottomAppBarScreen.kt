package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.CutCornerShape
import androidx.ui.layout.Column
import androidx.ui.layout.Padding
import androidx.ui.material.*
import androidx.ui.res.stringResource
import androidx.ui.text.TextStyle
import com.numero.jetpack_compose_example.R
import com.numero.jetpack_compose_example.core.VectorImage
import com.numero.jetpack_compose_example.core.VectorImageButton
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun BottomAppbarScreen() {
    var state by +state { DrawerState.Closed }
    BottomDrawerLayout(
            drawerState = state,
            onStateChange = {
                if (state != it) {
                    state = it
                }
            },
            gesturesEnabled = false,
            drawerContent = {
                BottomDrawerContent()
            },
            bodyContent = {
                BottomAppbarBodyContent {
                    state = DrawerState.Opened
                }
            }
    )
}

@Composable
private fun BottomAppbarBodyContent(openDrawer: () -> Unit) {
    val menu = listOf("Hoge", "Fuga")
    Column {
        TopAppBar(
                title = {
                    Text("BottomAppBar")
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
        VerticalScroller(modifier = Flexible(1f)) {
            BodyContent()
        }
        BottomAppBar(
                navigationIcon = {
                    VectorImageButton(
                            id = R.drawable.ic_menu,
                            tint = (+MaterialTheme.colors()).onPrimary
                    ) {
                        openDrawer()
                    }
                },
                fabConfiguration = BottomAppBar.FabConfiguration(
                        cutoutShape = CutCornerShape(36.dp)
                ) {
                    FloatingActionButton(
                            shape = CutCornerShape(28.dp),
                            color = (+MaterialTheme.colors()).secondary,
                            onClick = {
                                // TODO click fab
                            }
                    ) {
                        VectorImage(
                                id = R.drawable.ic_add,
                                tint = (+MaterialTheme.colors()).onSecondary
                        )
                    }
                },
                actionData = menu,
                action = {

                }
        )
    }
}

@Composable
private fun BodyContent() {
    val longText = +stringResource(R.string.large_text)
    val color = (+MaterialTheme.colors())
    val typo = (+MaterialTheme.typography())
    VerticalScroller {
        Padding(
                left = 16.dp,
                top = 16.dp,
                right = 16.dp
        ) {
            Text(
                    text = longText,
                    style = typo.body2.merge(
                            TextStyle(color = color.onBackground)
                    )
            )
        }
    }
}

@Composable
private fun BottomDrawerContent() {
    Text("Drawer")
}