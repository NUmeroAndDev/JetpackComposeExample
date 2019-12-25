package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Padding
import androidx.ui.material.DataTable
import androidx.ui.material.MaterialTheme
import androidx.ui.text.TextStyle

@Composable
fun DataTableScreen() {
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