package com.example.cuartaparte

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

@Composable
fun MySlider() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = sliderPosition,
            onValueChange = { sliderPosition = it })
        Text(text = sliderPosition.toString())
    }
}


@Composable
fun MySlider2() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }
    var completeValue by remember {
        mutableStateOf("")
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = {completeValue=sliderPosition.toString()},
            valueRange = 0f..10f,
            steps = 9  // hay que restar 2
        )
        Text(text = sliderPosition.toString())
        Text(text =completeValue.toString())
    }
}