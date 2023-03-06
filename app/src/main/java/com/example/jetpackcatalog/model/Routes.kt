package com.example.jetpackcatalog.model

sealed class Routes(val route:String) {
    object Pantalla1: Routes("Pantalla 1")
    object Pantalla2: Routes("Pantalla 2")
    object Pantalla3: Routes("Pantalla 3")

}
