package com.example.jetpackcatalog.ui.theme

data class CheckInfo(
    val title:String,
    var selected: Boolean = false,
    var onCheckedChange:(Boolean) -> Unit
){

}
