package com.example.jetpackcatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcatalog.ui.theme.JetPackCatalogTheme
import com.example.jetpackcatalog.ui.theme.MyRadioButton


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = "Pantalla 1") {
                        composable("Pantalla 1"){ Screen1(navigationController)}
                        composable("Pantalla 2"){ Screen2(navigationController)}
                        composable("Pantalla 3"){ Screen3(navigationController)}
                    }
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