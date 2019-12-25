package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.CutCornerShape
import androidx.ui.layout.Center
import androidx.ui.layout.FlexColumn
import androidx.ui.material.*
import com.numero.jetpack_compose_example.R
import com.numero.jetpack_compose_example.core.AppTheme
import com.numero.jetpack_compose_example.core.VectorImage
import com.numero.jetpack_compose_example.core.VectorImageButton

@Composable
fun BottomAppbarScreen() {
    val menu = listOf("Hoge", "Fuga")
    AppTheme {
        FlexColumn {
            expanded(1.0F) {
                VerticalScroller {
                    Text("Text")
                }
            }
            inflexible {
                BottomAppBar(
                    navigationIcon = {
                        VectorImageButton(
                            id = R.drawable.ic_menu,
                            tint = (+MaterialTheme.colors()).onPrimary
                        ) {
                            // TODO click navigation
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
    }
}