package com.numero.jetpack_compose_example.core.widget

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import com.numero.jetpack_compose_example.R

// Without action toolbar
@Composable
fun Toolbar(
        title: String? = null,
        isShowArrowBack: Boolean = false,
        onBackPressed: (() -> Unit)? = null
) {
    val navigationIcon: @Composable() (() -> Unit)? = if (isShowArrowBack) {
        {
            VectorImageButton(
                    id = R.drawable.ic_arrow_back,
                    tint = (+MaterialTheme.colors()).onPrimary
            ) {
                onBackPressed?.invoke()
            }
        }
    } else null
    TopAppBar(
            title = {
                if (title != null) {
                    Text(title)
                }
            },
            navigationIcon = navigationIcon
    )
}