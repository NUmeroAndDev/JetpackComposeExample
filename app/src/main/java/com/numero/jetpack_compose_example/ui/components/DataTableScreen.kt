package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.FlexColumn
import androidx.ui.layout.Padding
import androidx.ui.material.DataTable
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.text.TextStyle
import com.numero.jetpack_compose_example.R
import com.numero.jetpack_compose_example.core.VectorImageButton
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun DataTableScreen() {
    FlexColumn {
        inflexible {
            TopAppBar(
                    title = {
                        Text("DataTable")
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
            DataTableContent()
        }
    }
}

@Composable
private fun DataTableContent() {
    VerticalScroller {
        HorizontalScroller {
            DataTable(
                    columns = 20
            ) {
                headerRow {
                    Text(
                            text = "Header $it",
                            style = TextStyle(
                                    color = (+MaterialTheme.colors()).onBackground
                            )
                    )
                }
                (0..30).map { rowIndex ->
                    dataRow {
                        Padding(padding = 8.dp) {
                            Text(
                                    text = "Row $rowIndex Col $it",
                                    style = TextStyle(
                                            color = (+MaterialTheme.colors()).onBackground
                                    )
                            )
                        }
                    }
                }
            }
        }
    }
}