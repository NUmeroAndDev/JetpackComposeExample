package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Padding
import androidx.ui.material.DataTable
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Scaffold
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import com.numero.jetpack_compose_example.core.widget.Toolbar
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun DataTableScreen() {
    Scaffold(
            topAppBar = {
                Toolbar(
                        title = "DataTable",
                        isShowArrowBack = true,
                        onBackPressed = {
                            // TODO implement back press
                            navigateTo(Screen.Home)
                        }
                )
            },
            bodyContent = {
                DataTableContent()
            }
    )
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
                                    color = MaterialTheme.colors().onBackground
                            )
                    )
                }
                (0..30).map { rowIndex ->
                    dataRow {
                        Padding(padding = 8.dp) {
                            Text(
                                    text = "Row $rowIndex Col $it",
                                    style = TextStyle(
                                            color = MaterialTheme.colors().onBackground
                                    )
                            )
                        }
                    }
                }
            }
        }
    }
}