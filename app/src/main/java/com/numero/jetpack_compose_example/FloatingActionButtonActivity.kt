package com.numero.jetpack_compose_example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Context
import androidx.compose.unaryPlus
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.Padding
import androidx.ui.layout.Stack
import androidx.ui.material.AppBarIcon
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.TopAppBar
import androidx.ui.material.themeColor
import androidx.ui.res.stringResource
import com.numero.jetpack_compose_example.core.AppBarLayout
import com.numero.jetpack_compose_example.core.AppTheme

class FloatingActionButtonActivity : AppCompatActivity() {

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
                    TopAppBar<String>(
                        title = {
                            Text("FloatingActionButton")
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
        val longText = +stringResource(R.string.large_text)
        Stack {
            expanded {
                VerticalScroller {
                    Padding(16.dp) {
                        Text(longText)
                    }
                }
            }
            aligned(alignment = Alignment.BottomRight) {
                Padding(16.dp) {
                    FloatingActionButton(
                        icon = imageFromResource(resources, R.drawable.ic_add),
                        color = +themeColor { secondary },
                        onClick = {
                            // TODO click action
                        }
                    )
                }
            }
        }
    }

    companion object {
        fun createIntent(context: Context) =
            Intent(context, FloatingActionButtonActivity::class.java)
    }
}