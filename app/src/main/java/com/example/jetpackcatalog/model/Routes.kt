package com.example.jetpackcatalog.model

sealed class Routes(val route:String) {
    object Pantalla1: Routes("Pantalla 1")
    object Pantalla2: Routes("Pantalla 2")
    object Pantalla3: Routes("Pantalla 3")
    object Pantalla4: Routes("Pantalla4/{age}"){
        fun createRoute(age:Int) = "Pantalla4/$age"
    }   object Pantalla5: Routes("Pantalla5?name={name}"){
        fun createRoute(name:String) = "Pantalla5?name=$name"
    }
}
