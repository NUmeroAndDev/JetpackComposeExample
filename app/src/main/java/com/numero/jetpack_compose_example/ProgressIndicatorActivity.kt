package com.numero.jetpack_compose_example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Context
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.HeightSpacer
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.material.LinearProgressIndicator
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import com.numero.jetpack_compose_example.core.AppBarLayout
import com.numero.jetpack_compose_example.core.AppTheme
import com.numero.jetpack_compose_example.core.VectorImageButton

class ProgressIndicatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainPage()
        }
    }

    @Composable
    private fun mainPage() {
        AppTheme {
            AppBarLayout(
                appBar = {
                    TopAppBar(
                        title = {
                            Text("ProgressIndicator")
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
        VerticalScroller {
            Column {
                CircularProgressIndicator()
                HeightSpacer(32.dp)
                LinearProgressIndicator()
            }
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, ProgressIndicatorActivity::class.java)
    }
}