package com.numero.jetpack_compose_example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Context
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.FlexRow
import androidx.ui.layout.Padding
import androidx.ui.material.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            createListCompose()
        }
    }

    @Composable
    private fun createListCompose() {
        MaterialTheme {
            VerticalScroller {
                Column {
                    (0..20).forEachIndexed { index, _ ->
                        Padding(left = 16.dp, right = 16.dp, top = 12.dp, bottom = 12.dp) {
                            FlexRow {
                                expanded(1.0f) {
                                    Text("Item $index")
                                }
                                inflexible {
                                    Button(
                                        "Button $index",
                                        style = OutlinedButtonStyle(),
                                        onClick = {
                                            // TODO click action
                                        })
                                }
                            }
                        }
                        Divider(color = Color.LightGray, height = 1.dp)
                    }
                }
            }

        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, ListActivity::class.java)
    }
}