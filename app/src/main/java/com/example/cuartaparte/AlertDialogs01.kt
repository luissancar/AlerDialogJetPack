package com.example.cuartaparte


import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.DialogProperties


@Composable
fun MyAlertDialog(show: Boolean) {
    if (show) {
        AlertDialog(
            onDismissRequest = { },
            title = { Text(text = "Título") },
            text = { Text(text = "Contenido") },
            confirmButton = {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Dismiss")
                }
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        )
    }
}


@Composable
fun PrinMyAlertDialog() {
    var show by remember {
        mutableStateOf(false)
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostrar")

        }
        MyAlertDialog(
            show
        )
    }
}


@Composable
fun PrinMyAlertDialog2() {
    var show by remember {
        mutableStateOf(false)
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = true }) {
            Text(text = "Mostrar")

        }
        MyAlertDialog2(
            show,
            onDismiss = { show = false },
            onConfirm = { Log.i("men", "Confirm") })
    }
}

@Composable
fun MyAlertDialog2(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(onDismissRequest = { onDismiss() },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Contenido") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Dismiss")
                }
            })
    }
}
