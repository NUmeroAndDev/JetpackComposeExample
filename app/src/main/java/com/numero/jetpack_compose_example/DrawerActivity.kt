package com.numero.jetpack_compose_example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.*
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.Center
import androidx.ui.layout.Column
import androidx.ui.material.*
import com.numero.jetpack_compose_example.core.AppBarLayout
import com.numero.jetpack_compose_example.core.AppTheme

class DrawerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainPage()
        }
    }

    @Composable
    fun mainPage() {
        AppTheme {
            val state = +state { DrawerState.Closed }
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
    private fun drawerContent() {
        Text("Drawer")
    }

    @Composable
    private fun bodyContent(state: State<DrawerState>) {
        AppBarLayout(
            appBar = {
                TopAppBar(
                    title = {
                        Text("Drawer")
                    },
                    navigationIcon = {
                        AppBarIcon(imageFromResource(resources, R.drawable.ic_arrow_back)) {
                            onBackPressed()
                        }
                    }
                )
            },
            content = {
                content(state)
            }
        )
    }

    @Composable
    private fun content(state: State<DrawerState>) {
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