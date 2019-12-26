package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import com.numero.jetpack_compose_example.model.Component

@Composable
fun ComponentDetailScreen(component: Component) {
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