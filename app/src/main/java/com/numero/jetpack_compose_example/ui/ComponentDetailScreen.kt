package com.numero.jetpack_compose_example.ui

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import com.numero.jetpack_compose_example.R
import com.numero.jetpack_compose_example.core.AppBarLayout
import com.numero.jetpack_compose_example.core.VectorImageButton
import com.numero.jetpack_compose_example.model.Component

@Composable
fun ComponentDetailScreen(component: Component) {
    AppBarLayout(
        appBar = {
            TopAppBar(
                title = {
                    Text(component.label)
                },
                navigationIcon = {
                    VectorImageButton(
                        id = R.drawable.ic_arrow_back,
                        tint = (+MaterialTheme.colors()).onPrimary
                    ) {
                        // TODO back press
                    }
                }
            )
        },
        content = {
            // TODO show component detail
        }
    )
}