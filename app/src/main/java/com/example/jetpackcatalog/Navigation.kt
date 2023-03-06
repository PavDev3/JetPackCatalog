package com.example.jetpackcatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun Screen1(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan)){
        Text(text = "Pantalla 1", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate("Pantalla 2") })
    }
}

@Composable
fun Screen2(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue)){
        Text(text = "Pantalla 2", modifier = Modifier.align(Alignment.Center).clickable { navController.navigate("Pantalla 3") })
    }
}

@Composable
fun Screen3(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Magenta)){
        Text(text = "Pantalla 3", modifier = Modifier.align(Alignment.Center))
    }
}