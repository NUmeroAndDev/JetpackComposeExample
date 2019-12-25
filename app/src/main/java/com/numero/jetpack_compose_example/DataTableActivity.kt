package com.numero.jetpack_compose_example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Context
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Padding
import androidx.ui.material.DataTable
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.text.TextStyle
import com.numero.jetpack_compose_example.core.AppBarLayout
import com.numero.jetpack_compose_example.core.AppTheme
import com.numero.jetpack_compose_example.core.VectorImageButton

class DataTableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainPage()
        }
    }

    @Composable
    fun mainPage() {
        AppTheme {
            AppBarLayout(
                appBar = {
                    TopAppBar(
                        title = {
                            Text("DataTable")
                        },
                        navigationIcon = {
                            VectorImageButton(
                                id = R.drawable.ic_arrow_back,
                                tint = (+MaterialTheme.colors()).onPrimary
                            ) {
                                onBackPressed()
                            }
                        }
                    )
                },
                content = {
                    content()
                }
            )
        }
    }

    private fun content() {
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

    companion object {
        fun createIntent(context: Context) = Intent(context, DataTableActivity::class.java)
    }
}