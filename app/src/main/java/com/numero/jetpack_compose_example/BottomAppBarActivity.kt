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
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.CutCornerShape
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.FlexColumn
import androidx.ui.material.*

class BottomAppBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainPage()
        }
    }

    @Composable
    fun mainPage() {
        val menu = listOf("Hoge", "Fuga")
        MaterialTheme {
            FlexColumn {
                expanded(1.0F) {
                    VerticalScroller {
                        Text("Text")
                    }
                }
                inflexible {
                    BottomAppBar<String>(
                        navigationIcon = {
                            AppBarIcon(
                                imageFromResource(
                                    resources,
                                    R.drawable.ic_menu
                                )
                            ) {
                                // TODO click navigation
                            }
                        },
                        fabConfiguration = BottomAppBar.FabConfiguration(
                            cutoutShape = CutCornerShape(36.dp)
                        ) {
                            FloatingActionButton(
                                icon = imageFromResource(
                                    resources,
                                    R.drawable.ic_add
                                ),
                                shape = CutCornerShape(28.dp),
                                color = +themeColor { secondary },
                                onClick = {

                                }
                            )
                        },
                        contextualActions = menu,
                        action = {

                        }
                    )
                }
            }
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, BottomAppBarActivity::class.java)
    }
}