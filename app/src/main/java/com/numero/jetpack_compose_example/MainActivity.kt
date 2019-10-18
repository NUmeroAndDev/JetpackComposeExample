package com.numero.jetpack_compose_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.HeightSpacer
import androidx.ui.layout.Padding
import androidx.ui.material.Button
import androidx.ui.material.TopAppBar
import com.numero.jetpack_compose_example.core.AppBarLayout
import com.numero.jetpack_compose_example.core.AppTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainPage()
        }
    }

    @Composable
    private fun mainPage() {
        AppTheme {
            AppBarLayout(
                appBar = {
                    TopAppBar<String>(
                        title = {
                            Text("Jetpack Compose Example")
                        }
                    )
                },
                content = {
                    content()
                }
            )
        }
    }

    @Composable
    private fun content() {
        VerticalScroller {
            Padding(left = 16.dp, right = 16.dp) {
                Column {
                    Button(text = "AlertDialog", onClick = {
                        startActivity(AlertDialogActivity.createIntent(this))
                    })
                    HeightSpacer(16.dp)
                    Button(text = "BottomAppBar", onClick = {
                        startActivity(BottomAppBarActivity.createIntent(this))
                    })
                    HeightSpacer(16.dp)
                    Button(text = "Button", onClick = {
                        startActivity(ButtonActivity.createIntent(this))
                    })
                    HeightSpacer(16.dp)
                    Button(text = "DataTable", onClick = {
                        startActivity(DataTableActivity.createIntent(this))
                    })
                    HeightSpacer(16.dp)
                    Button(text = "Drawer", onClick = {
                        startActivity(DrawerActivity.createIntent(this))
                    })
                    HeightSpacer(16.dp)
                    Button(text = "FloatingActionButton", onClick = {
                        startActivity(FloatingActionButtonActivity.createIntent(this))
                    })
                    HeightSpacer(16.dp)
                    Button(text = "ProgressIndicator", onClick = {
                        startActivity(ProgressIndicatorActivity.createIntent(this))
                    })
                    HeightSpacer(16.dp)
                    Button(text = "List", onClick = {
                        startActivity(ListItemActivity.createIntent(this))
                    })
                    HeightSpacer(16.dp)
                    Button(text = "Tab", onClick = {
                        startActivity(TabActivity.createIntent(this))
                    })
                }
            }
        }
    }
}