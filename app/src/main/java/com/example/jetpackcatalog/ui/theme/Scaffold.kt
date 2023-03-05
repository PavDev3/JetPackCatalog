package com.example.jetpackcatalog.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        MyTopAppBar(onClickIcon = {
            coroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    "Has pulsado $it"
                )
            }
        }, onClickDrawer = { coroutineScope.launch { scaffoldState.drawerState.open() } })
    },
        scaffoldState = scaffoldState,
        bottomBar = { MyBottomBar() },
        drawerContent = { MyDrawer() }) {
    }
}


@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onClickDrawer: () -> Unit) {
    TopAppBar(
        title = { Text(text = "ToolBar APP") },
        backgroundColor = Color.DarkGray,
        contentColor = Color.White,
        navigationIcon = {
            IconButton(onClick = { onClickDrawer() }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")

            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
            }
            IconButton(onClick = { onClickIcon("Cerrar") }) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "cross")
            }
        }

    )
}

@Composable
fun MyBottomBar() {
    var index by remember { mutableStateOf(0) }

    BottomNavigation(backgroundColor = Color.DarkGray, contentColor = Color.White) {
        BottomNavigationItem(selected = index == 0, onClick = { index = 0 }, icon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home Buton"
            )
        }, label = { Text(text = "Home") })
        BottomNavigationItem(selected = index == 1, onClick = { index = 1 }, icon = {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite Buton"
            )
        }, label = { Text(text = "Favorite") })
        BottomNavigationItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person Button"
            )
        }, label = { Text(text = "Favorite") })
    }
}

@Composable
fun MyDrawer() {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = "Primera Opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
        Text(
            text = "Segunda Opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
        Text(
            text = "Tercera Opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )
        Text(
            text = "Cuarta Opcion", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

    }
}