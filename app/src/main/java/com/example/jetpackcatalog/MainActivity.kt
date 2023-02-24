package com.example.jetpackcatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.jetpackcatalog.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var show by remember {mutableStateOf(false) }
                    Box(Modifier.fillMaxSize()) {
                        Button(onClick = { show = true}) {
                            Text(text = "Mostrar dialogo")

                        }
                        MyConfirmationDialog(show = show, onDismiss = { show = false})

                    }
                }
            }
        }
    }
}

