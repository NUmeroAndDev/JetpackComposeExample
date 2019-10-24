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
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.Column
import androidx.ui.layout.HeightSpacer
import androidx.ui.material.*
import com.numero.jetpack_compose_example.core.AppBarLayout
import com.numero.jetpack_compose_example.core.AppTheme

class ButtonActivity : AppCompatActivity() {

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
                            Text("Button")
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
                Button(
                    text = "ContainedButton",
                    onClick = {
                    },
                    style = ContainedButtonStyle()
                )
                HeightSpacer(32.dp)
                Button(
                    text = "OutlinedButton",
                    onClick = {
                    },
                    style = OutlinedButtonStyle()
                )
                HeightSpacer(32.dp)
                Button(
                    text = "TextButton",
                    onClick = {
                    },
                    style = TextButtonStyle()
                )
            }
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, ButtonActivity::class.java)
    }
}