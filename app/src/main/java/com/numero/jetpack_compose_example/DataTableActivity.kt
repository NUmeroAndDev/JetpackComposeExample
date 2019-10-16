package com.numero.jetpack_compose_example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Context
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.Column
import androidx.ui.layout.Padding
import androidx.ui.material.*
import androidx.ui.text.TextStyle
import com.numero.jetpack_compose_example.core.AppBarLayout
import com.numero.jetpack_compose_example.core.AppTheme

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
                    TopAppBar<String>(
                        title = {
                            Text("DataTable")
                        },
                        navigationIcon = {
                            AppBarIcon(imageFromResource(resources, R.drawable.ic_arrow_back)) {
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
                    rows = createRows(),
                    columns = 20,
                    header = {
                        Text(
                            text = "Header $it",
                            style = TextStyle(
                                color = +themeColor { onBackground }
                            )
                        )
                    }
                )
            }
        }
    }

    @Composable
    private fun createRows(): List<DataRow> {
        return (0..30).map { rowIndex ->
            DataRow(
                children = {
                    Padding(padding = 8.dp) {
                        Text(
                            text = "Row $rowIndex Col $it",
                            style = TextStyle(
                                color = +themeColor { onBackground }
                            )
                        )
                    }
                }
            )
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, DataTableActivity::class.java)
    }
}