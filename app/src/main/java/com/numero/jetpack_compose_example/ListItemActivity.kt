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
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.Column
import androidx.ui.material.AppBarIcon
import androidx.ui.material.Divider
import androidx.ui.material.ListItem
import androidx.ui.material.TopAppBar
import com.numero.jetpack_compose_example.core.AppBarLayout
import com.numero.jetpack_compose_example.core.AppTheme

class ListItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            createListCompose()
        }
    }

    @Composable
    private fun createListCompose() {
        AppTheme {
            AppBarLayout(
                appBar = {
                    TopAppBar<String>(
                        title = {
                            Text("List")
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

    @Composable
    private fun content() {
        VerticalScroller {
            Column {
                (0..5).forEachIndexed { index, _ ->
                    ListItem(
                        text = "OneLineItem $index",
                        onClick = {
                        }
                    )
                    Divider(color = Color.LightGray, height = 1.dp)
                }
                (0..5).forEachIndexed { index, _ ->
                    ListItem(
                        text = "TwoLineItem $index",
                        secondaryText = "SecondaryText",
                        onClick = {
                        }
                    )
                    Divider(color = Color.LightGray, height = 1.dp)
                }
                (0..5).forEachIndexed { index, _ ->
                    ListItem(
                        text = "ThreeLineItem $index",
                        secondaryText = "SecondaryText",
                        overlineText = "OverlineText",
                        metaText = "MetaText",
                        onClick = {
                        }
                    )
                    Divider(color = Color.LightGray, height = 1.dp)
                }
            }
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, ListItemActivity::class.java)
    }
}