package com.example.cuartaparte

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun RadioButtonList(name: String, onItemSelected: (String) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.padding(6.dp),verticalAlignment = Alignment.CenterVertically) {

            RadioButton(
                selected = name == "Radio 1", onClick = { onItemSelected("Radio 1") })
            Text(text = "Radio 1")
        }
        Row(Modifier.padding(6.dp),verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Radio 2", onClick = { onItemSelected("Radio 2") })
            Text(text = "Radio 2")
        }
        Row(Modifier.padding(6.dp),verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Radio 3", onClick = { onItemSelected("Radio 3") })
            Text(text = "Radio 3")
        }
        Row(Modifier.padding(6.dp),verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Radio 4", onClick = { onItemSelected("Radio 4") })
            Text(text = "Radio 4")
        }



    }
}
