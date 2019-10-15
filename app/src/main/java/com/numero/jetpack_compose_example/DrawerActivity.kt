package com.numero.jetpack_compose_example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.*
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.layout.Center
import androidx.ui.layout.Column
import androidx.ui.material.*

class DrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainPage()
        }
    }

    @Composable
    fun mainPage() {
        val state = +state { DrawerState.Closed }
        MaterialTheme {
            ModalDrawerLayout(
                drawerState = state.value,
                onStateChange = {
                    if (state.value != it) {
                        state.value = it
                    }
                },
                drawerContent = {
                    drawerContent()
                },
                bodyContent = {
                    bodyContent(state)
                }
            )
        }
    }

    @Composable
    fun drawerContent() {
        Text("Drawer")
    }

    @Composable
    fun bodyContent(state: State<DrawerState>) {
        Center {
            Column {
                Button(
                    text = "Show drawer",
                    onClick = {
                        state.value = DrawerState.Opened
                    }
                )
            }
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, DrawerActivity::class.java)
    }
}