package com.example.cuartaparte


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onOk:(texto:String)->Unit,
    salir:()->Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {

            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                TitleDialog(text = "Sonidos",modifier=Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                var selected by rememberSaveable {
                    mutableStateOf("Radio 1")
                }

                RadioButtonList(name = selected) {
                    selected = it
                }
                Divider(Modifier.fillMaxWidth(), color = Color.LightGray)
                Row(
                    Modifier
                        .align(Alignment.End)
                        .padding(8.dp)) {
                    TextButton(
                        onClick = {onOk("cancel")
                        salir()
                    }) {
                        Text(text = "CANCEL")
                        
                    }
                    TextButton(
                        onClick = {
                            onOk(selected)
                            salir() }
                    ) {
                        Text("OK")

                    }
                }
            }
        }
    }
}


@Composable
fun PrintConfirmationDialog() {
    var show by remember {
        mutableStateOf(false)
    }
    var texto by remember {
        mutableStateOf("")
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostrar")

        }
        MyConfirmationDialog(
            show,
            onDismiss = { show = false },
            onOk = {texto=it},
            salir = {show=false}
        )
    }
    Text(text = texto)
}