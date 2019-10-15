package com.numero.jetpack_compose_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.CrossAxisAlignment
import androidx.ui.layout.LayoutSize
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainPage()
        }
    }

    @Composable
    fun mainPage() {
        MaterialTheme {
            VerticalScroller {
                Column(
                    mainAxisSize = LayoutSize.Expand,
                    crossAxisAlignment = CrossAxisAlignment.Start
                ) {
                    Button(text = "BottomAppBar", onClick = {
                        startActivity(BottomAppBarActivity.createIntent(this))
                    })

                    Button(text = "Show List", onClick = {
                        startActivity(ListActivity.createIntent(this))
                    })
                }
            }
        }

    }
}