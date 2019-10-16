package com.numero.jetpack_compose_example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Context
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.HeightSpacer
import androidx.ui.material.Button
import androidx.ui.material.ContainedButtonStyle
import androidx.ui.material.OutlinedButtonStyle
import androidx.ui.material.TextButtonStyle
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

    }

    companion object {
        fun createIntent(context: Context) = Intent(context, ButtonActivity::class.java)
    }
}