package com.numero.jetpack_compose_example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Context
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.imageFromResource
import androidx.ui.layout.Padding
import androidx.ui.material.*
import androidx.ui.text.TextStyle
import com.numero.jetpack_compose_example.core.AppBarLayout
import com.numero.jetpack_compose_example.core.AppTheme

class TabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainPage()
        }
    }

    @Composable
    fun mainPage() {
        val tabList = listOf(TabItem.TAB1, TabItem.TAB2, TabItem.TAB3)
        val viewModel = TabViewModel(tabList.first())
        AppTheme {
            AppBarLayout(
                appBar = {
                    TopAppBar<String>(
                        title = {
                            Text("AlertDialog")
                        },
                        navigationIcon = {
                            AppBarIcon(imageFromResource(resources, R.drawable.ic_arrow_back)) {
                                onBackPressed()
                            }
                        }
                    )
                    setupTab(viewModel, tabList)
                },
                content = {
                    content(viewModel)
                }
            )
        }
    }

    @Composable
    private fun content(viewModel: TabViewModel) {
        viewModel.selectedTabItem.contentScreen()
    }

    @Composable
    private fun setupTab(viewModel: TabViewModel, tabItemList: List<TabItem>) {
        TabRow(
            items = tabItemList,
            selectedIndex = tabItemList.indexOf(viewModel.selectedTabItem),
            tab = { index, tabItem ->
                Tab(
                    text = tabItem.label,
                    selected = tabItem == viewModel.selectedTabItem,
                    onSelected = {
                        viewModel.selectedTabItem = tabItem
                    }
                )
            }
        )
    }

    private enum class TabItem(val label: String) {
        TAB1("Tab1"),
        TAB2("Tab2"),
        TAB3("Tab3")
    }

    @Composable
    private fun TabItem.contentScreen() {
        when (this) {
            TabItem.TAB1 -> {
                VerticalScroller {
                    Padding(16.dp) {
                        Text(
                            text = label,
                            style = TextStyle(
                                color = +themeColor { onBackground }
                            )
                        )
                    }
                }
            }
            TabItem.TAB2 -> {
                VerticalScroller {
                    Padding(16.dp) {
                        Text(
                            text = label,
                            style = TextStyle(
                                color = +themeColor { onBackground }
                            )
                        )
                    }
                }
            }
            TabItem.TAB3 -> {
                VerticalScroller {
                    Padding(16.dp) {
                        Text(
                            text = label,
                            style = TextStyle(
                                color = +themeColor { onBackground }
                            )
                        )
                    }
                }
            }
        }
    }

    private class TabViewModel(firstTabItem: TabItem) {
        var selectedTabItem by +state { firstTabItem }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, TabActivity::class.java)
    }
}