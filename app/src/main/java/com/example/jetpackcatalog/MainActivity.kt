package com.example.jetpackcatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcatalog.ui.theme.JetPackCatalogTheme
import com.example.jetpackcatalog.ui.theme.MyRadioButton
import com.example.jetpackcatalog.ui.theme.MyScaffoldExample
import com.example.jetpackcatalog.ui.theme.SuperHeroGridView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    MyScaffoldExample()

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackCatalogTheme {
        MyRadioButton()
    }
}