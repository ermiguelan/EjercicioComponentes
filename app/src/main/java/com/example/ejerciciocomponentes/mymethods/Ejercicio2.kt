package com.example.ejerciciocomponentes.mymethods

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejerciciocomponentes.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Ejercicio2() {

    var mensaje by remember { mutableStateOf("") }
    var mostrarTexto by remember { mutableStateOf(false) }
    var mostrarRadios by remember { mutableStateOf(false) }
    var opcionSeleccionada by remember { mutableStateOf("") }
    var cargando by remember { mutableStateOf(false) }
    var imagenActual by remember { mutableStateOf(R.drawable.asno) }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Button(
            onClick = {
                if (imagenActual == R.drawable.asno) {
                    imagenActual = R.drawable.sixseven
                } else if (imagenActual == R.drawable.sixseven) {
                    imagenActual = R.drawable.triple_t
                } else {
                    imagenActual = R.drawable.asno
                }

                scope.launch {
                    cargando = true
                    delay(5000)
                    cargando = false
                }
            }
        ) {
            Text("Presionar")
        }

        Spacer(modifier = Modifier.height(10.dp))


        if (cargando) {
            CircularProgressIndicator()
        }

        Spacer(modifier = Modifier.height(10.dp))


        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = mostrarTexto,
                onCheckedChange = {
                    mostrarTexto = it
                }
            )

            Text("Activar")
        }

        if (mostrarTexto) {
            Text(
                text = mensaje,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))


        Icon(
            imageVector = Icons.Default.Face,
            contentDescription = "Icono de una cara"
        )

        Spacer(modifier = Modifier.height(10.dp))


        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Mostrar opciones")

            Switch(
                checked = mostrarRadios,
                onCheckedChange = {
                    mostrarRadios = it
                }
            )
        }


        if (mostrarRadios) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = opcionSeleccionada == "Opción 1",
                    onClick = {
                        opcionSeleccionada = "Opción 1"
                        mensaje = "Seleccionada Opción 1"
                    }
                )
                Text("Opción 1")
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = opcionSeleccionada == "Opción 2",
                    onClick = {
                        opcionSeleccionada = "Opción 2"
                        mensaje = "Seleccionada Opción 2"
                    }
                )
                Text("Opción 2")
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = opcionSeleccionada == "Opción 3",
                    onClick = {
                        opcionSeleccionada = "Opción 3"
                        mensaje = "Seleccionada Opción 3"
                    }
                )
                Text("Opción 3")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))


        Image(
            painter = painterResource(id = imagenActual),
            contentDescription = "Imagen seleccionada"
        )
    }
}