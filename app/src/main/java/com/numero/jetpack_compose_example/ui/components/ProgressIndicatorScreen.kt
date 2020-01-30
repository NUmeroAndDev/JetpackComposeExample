package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.ui.layout.*
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.material.LinearProgressIndicator
import androidx.ui.unit.dp
import com.numero.jetpack_compose_example.core.widget.Toolbar
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun ProgressIndicatorScreen() {
    FlexColumn {
        inflexible {
            Toolbar(
                    title = "ProgressIndicator",
                    isShowArrowBack = true,
                    onBackPressed = {
                        // TODO implement back press
                        navigateTo(Screen.Home)
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
            Spacer(modifier = LayoutHeight(32.dp) + LayoutWidth.Fill)
            LinearProgressIndicator()
        }
    }
}