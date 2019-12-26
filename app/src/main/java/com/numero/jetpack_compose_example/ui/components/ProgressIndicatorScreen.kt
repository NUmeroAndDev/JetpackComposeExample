package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.layout.Center
import androidx.ui.layout.Column
import androidx.ui.layout.FlexColumn
import androidx.ui.layout.HeightSpacer
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.material.LinearProgressIndicator
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import com.numero.jetpack_compose_example.R
import com.numero.jetpack_compose_example.core.VectorImageButton
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun ProgressIndicatorScreen() {
    FlexColumn {
        inflexible {
            TopAppBar(
                    title = {
                        Text("ProgressIndicator")
                    },
                    navigationIcon = {
                        VectorImageButton(
                                id = R.drawable.ic_arrow_back,
                                tint = (+MaterialTheme.colors()).onPrimary
                        ) {
                            // TODO implement back press
                            navigateTo(Screen.Home)
                        }
                    }
            )
        }
        expanded(1.0f) {
            ProgressIndicatorContent()
        }
    }
}

@Composable
private fun ProgressIndicatorContent() {
    Center {
        Column {
            CircularProgressIndicator()
            HeightSpacer(32.dp)
            LinearProgressIndicator()
        }
    }
}