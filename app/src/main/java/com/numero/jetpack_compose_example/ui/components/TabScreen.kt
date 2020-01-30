package com.numero.jetpack_compose_example.ui.components

import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.layout.Center
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Tab
import androidx.ui.material.TabRow
import androidx.ui.text.TextStyle
import com.numero.jetpack_compose_example.core.widget.Toolbar
import com.numero.jetpack_compose_example.ui.Screen
import com.numero.jetpack_compose_example.ui.navigateTo

@Composable
fun TabScreen() {
    val tabItemList = listOf(
        TabItem.TAB1,
        TabItem.TAB2,
        TabItem.TAB3
    )

    var selectedTabItem by state { tabItemList.first() }

    Column {
        Toolbar(
                title = "Tab",
                isShowArrowBack = true,
                onBackPressed = {
                    // TODO implement back press
                    navigateTo(Screen.Home)
                }
        )
        TabRow(
            items = tabItemList,
            selectedIndex = tabItemList.indexOf(selectedTabItem)
        ) { _, tabItem ->
            Tab(
                text = tabItem.label,
                selected = tabItem == selectedTabItem,
                onSelected = {
                    selectedTabItem = tabItem
                }
            )
        }
        Container(modifier = LayoutFlexible(1f)) {
            selectedTabItem.contentScreen()
        }
    }
}

@Composable
fun TabItem.contentScreen() {
    when (this) {
        TabItem.TAB1 -> {
            Center {
                Text(
                    text = label,
                    style = TextStyle(
                        color = MaterialTheme.colors().onBackground
                    )
                )
            }
        }
        TabItem.TAB2 -> {
            Center {
                Text(
                    text = label,
                    style = TextStyle(
                        color = MaterialTheme.colors().onBackground
                    )
                )
            }
        }
        TabItem.TAB3 -> {
            Center {
                Text(
                    text = label,
                    style = TextStyle(
                        color = MaterialTheme.colors().onBackground
                    )
                )
            }
        }
    }
}

enum class TabItem(val label: String) {
    TAB1("Tab1"),
    TAB2("Tab2"),
    TAB3("Tab3")
}