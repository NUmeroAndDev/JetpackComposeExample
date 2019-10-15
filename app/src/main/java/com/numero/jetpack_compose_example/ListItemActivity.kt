package com.numero.jetpack_compose_example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Context
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.material.Divider
import androidx.ui.material.ListItem
import androidx.ui.material.MaterialTheme

class ListItemActivity : AppCompatActivity() {

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
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, ListItemActivity::class.java)
    }
}