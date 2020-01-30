package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.remember
import androidx.compose.state
import androidx.ui.core.Modifier
import androidx.ui.core.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.CutCornerShape
import androidx.ui.layout.LayoutPadding
import androidx.ui.material.*
import androidx.ui.res.stringResource
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import com.numero.jetpack_compose_example.R
import com.numero.jetpack_compose_example.core.widget.Toolbar
import com.numero.jetpack_compose_example.core.widget.VectorImage
import com.numero.jetpack_compose_example.core.widget.VectorImageButton
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun BottomAppbarScreen() {
    var state by state { DrawerState.Closed }
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
    val scaffoldState = remember { ScaffoldState() }
    val fabShape = CutCornerShape(50)

    Scaffold(
            scaffoldState = scaffoldState,
            topAppBar = {
                Toolbar(
                        title = "BottomAppBar",
                        isShowArrowBack = true,
                        onBackPressed = {
                            // TODO implement back press
                            navigateTo(Screen.Home)
                        }
                )
            },
            bottomAppBar = { fabConfiguration ->
                BottomAppBar<Unit>(
                        fabConfiguration = fabConfiguration,
                        cutoutShape = fabShape,
                        navigationIcon = {
                            VectorImageButton(
                                    id = R.drawable.ic_menu,
                                    tint = MaterialTheme.colors().onPrimary
                            ) {
                                openDrawer()
                            }
                        }
                )
            },
            floatingActionButton = {
                FloatingActionButton(
                        shape = fabShape,
                        color = MaterialTheme.colors().secondary,
                        onClick = {
                            // TODO action
                        }
                ) {
                    VectorImage(
                            id = R.drawable.ic_add,
                            tint = MaterialTheme.colors().onSecondary
                    )
                }
            },
            floatingActionButtonPosition = Scaffold.FabPosition.CenterDocked,
            bodyContent = { modifier ->
                BodyContent(modifier = modifier)
            }
    )
}

@Composable
private fun BodyContent(modifier: Modifier) {
    val longText = stringResource(R.string.large_text)
    val color = MaterialTheme.colors()
    val typo = MaterialTheme.typography()
    VerticalScroller(modifier = modifier) {
        Text(
                modifier = LayoutPadding(16.dp),
                text = longText,
                style = typo.body2.merge(
                        TextStyle(color = color.onBackground)
                )
        )
    }
}

@Composable
private fun BottomDrawerContent() {
    Text("Drawer")
}