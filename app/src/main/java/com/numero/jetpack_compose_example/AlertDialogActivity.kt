package com.numero.jetpack_compose_example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Context
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.material.AlertDialog
import androidx.ui.material.Button
import com.numero.jetpack_compose_example.core.AppTheme

class AlertDialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainPage()
        }
    }

    @Composable
    fun mainPage() {
        val isShowProgress = +state { false }
        AppTheme {
            VerticalScroller {
                Column {
                    Button(
                        text = "Show Alert Dialog",
                        onClick = {
                            isShowProgress.value = true
                        }
                    )
                }
            }
            if (isShowProgress.value) {
                AlertDialog(
                    onCloseRequest = {
                        isShowProgress.value = false
                    },
                    title = {
                        Text("Title")
                    },
                    text = {
                        Text("Message")
                    },
                    confirmButton = {
                        Button(
                            text = "OK",
                            onClick = {
                                isShowProgress.value = false
                            }
                        )
                    }
                )
            }
        }

    }

    companion object {
        fun createIntent(context: Context) = Intent(context, AlertDialogActivity::class.java)
    }
}