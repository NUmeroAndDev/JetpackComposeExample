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
import androidx.ui.res.stringResource
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
                    tab()
                },
                content = {
                    content()
                }
            )
        }
    }

    @Composable
    private fun content() {
        val longText = +stringResource(R.string.large_text)
        VerticalScroller {
            Padding(16.dp) {
                Text(
                    text = longText,
                    style = TextStyle(
                        color = +themeColor { onBackground }
                    )
                )
            }
        }
    }

    @Composable
    private fun tab() {
        val tabList = listOf(TabItem.TAB1, TabItem.TAB2, TabItem.TAB3)
        val selectedTabItem = +state { tabList.first() }
        TabRow(
            items = tabList,
            selectedIndex = tabList.indexOf(selectedTabItem.value),
            tab = { index, tabItem ->
                Tab(
                    text = tabItem.label,
                    selected = tabItem == selectedTabItem.value,
                    onSelected = {
                        selectedTabItem.value = tabItem
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

    companion object {
        fun createIntent(context: Context) = Intent(context, TabActivity::class.java)
    }
}