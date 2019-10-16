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
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.material.LinearProgressIndicator
import com.numero.jetpack_compose_example.core.AppTheme

class ProgressIndicatorActivity : AppCompatActivity() {

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
                    CircularProgressIndicator()
                    HeightSpacer(32.dp)
                    LinearProgressIndicator()
                }
            }
        }

    }

    companion object {
        fun createIntent(context: Context) = Intent(context, ProgressIndicatorActivity::class.java)
    }
}