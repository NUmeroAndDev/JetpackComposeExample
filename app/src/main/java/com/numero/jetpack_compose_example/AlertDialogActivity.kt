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
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.Column
import androidx.ui.material.AlertDialog
import androidx.ui.material.AppBarIcon
import androidx.ui.material.Button
import androidx.ui.material.TopAppBar
import com.numero.jetpack_compose_example.core.AppBarLayout
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
        AppTheme {
            AppBarLayout(
                appBar = {
                    TopAppBar(
                        title = {
                            Text("AlertDialog")
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
        val isShowProgress = +state { false }
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

    companion object {
        fun createIntent(context: Context) = Intent(context, AlertDialogActivity::class.java)
    }
}