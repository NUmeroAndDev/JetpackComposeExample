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
import androidx.ui.layout.Padding
import androidx.ui.layout.Stack
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.res.stringResource
import androidx.ui.text.TextStyle
import com.numero.jetpack_compose_example.core.AppBarLayout
import com.numero.jetpack_compose_example.core.AppTheme
import com.numero.jetpack_compose_example.core.VectorImage
import com.numero.jetpack_compose_example.core.VectorImageButton

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
                    TopAppBar(
                        title = {
                            Text("FloatingActionButton")
                        },
                        navigationIcon = {
                            VectorImageButton(
                                id = R.drawable.ic_arrow_back,
                                tint = (+MaterialTheme.colors()).onPrimary
                            ) {
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
                        Text(
                            text = longText,
                            style = TextStyle(
                                color = (+MaterialTheme.colors()).onBackground
                            )
                        )
                    }
                }
            }
            aligned(alignment = Alignment.BottomRight) {
                Padding(16.dp) {
                    FloatingActionButton(
                        color = (+MaterialTheme.colors()).secondary,
                        onClick = {
                            // TODO click action
                        }
                    ) {
                        VectorImage(
                            id = R.drawable.ic_add,
                            tint = (+MaterialTheme.colors()).onSecondary
                        )
                    }
                }
            }
        }
    }

    companion object {
        fun createIntent(context: Context) =
            Intent(context, FloatingActionButtonActivity::class.java)
    }
}