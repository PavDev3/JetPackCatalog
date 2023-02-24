package com.example.jetpackcatalog.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyBasicSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0.0f) }
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun AdvanceSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0.0f) }
        var completedValue by remember { mutableStateOf("") }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = { completedValue = sliderPosition.toString() },
            valueRange = 0.0f..10.0f,
            steps = 9
        )
        Text(text = completedValue)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(8.dp)) {
        var sliderPosition by remember { mutableStateOf(0.0f..10f) }

        androidx.compose.material.RangeSlider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..10f,
            steps = 9
        )
        Text(text = "Minimo valor en ${sliderPosition.start}")
        Text(text = "Minimo valor en ${sliderPosition.endInclusive}")
    }
}