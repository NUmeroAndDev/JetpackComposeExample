package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import com.numero.jetpack_compose_example.R
import com.numero.jetpack_compose_example.core.AppBarLayout
import com.numero.jetpack_compose_example.core.VectorImageButton
import com.numero.jetpack_compose_example.model.Component
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

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
                        // TODO implement back press
                        navigateTo(Screen.Home)
                    }
                }
            )
        },
        content = {
            when (component) {
                Component.AlertDialog -> AlertDialogScreen()
                Component.BottomAppBar -> BottomAppbarScreen()
                Component.Button -> ButtonScreen()
                Component.DataTable -> DataTableScreen()
                Component.Drawer -> DrawerScreen()
                Component.FloatingActionButton -> FloatingActionButtonScreen()
                Component.ProgressIndicator -> ProgressIndicatorScreen()
                Component.Slider -> SliderScreen()
                Component.List -> ListScreen()
                Component.Tab -> TabScreen()
            }
        }
    )
}