package com.example.ejerciciocomponentes.mymethods

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ejerciciocomponentes.clases.Tarea

@Composable
fun ListaTareas(modifier: Modifier = Modifier) {

    val tareas = remember {
        mutableStateListOf(
            Tarea("Estudiar Java", false, "Alta"),
            Tarea("Hacer ejercicios", false, "Media"),
            Tarea("Repasar bases de datos", true, "Baja"),
            Tarea("Preparar examen", false, "Alta"),
            Tarea("Entregar práctica", true, "Media")
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = "Lista de tareas",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Tareas pendientes",
            style = MaterialTheme.typography.titleLarge
        )


        for (tarea in tareas) {
            if (!tarea.completada) {
                TarjetaTarea(tarea)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        HorizontalDivider()

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Tareas completadas",
            style = MaterialTheme.typography.titleLarge
        )

        // Recorremos la lista y mostramos solo las completadas
        for (tarea in tareas) {
            if (tarea.completada) {
                TarjetaTarea(tarea)
            }
        }
    }
}

@Composable
fun TarjetaTarea(tarea: Tarea) {

    var menuEstadoAbierto by remember { mutableStateOf(false) }
    var menuPrioridadAbierto by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            // Nombre a la izquierda y badge a la derecha
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = tarea.nombre,
                    style = MaterialTheme.typography.titleMedium
                )

                BadgedBox(
                    modifier = Modifier.padding(end = 40.dp),
                    badge = {
                        Badge {
                            Text(tarea.prioridad)

                        }
                    }
                ) {
                    Text("Prioridad",
                        modifier = Modifier.padding(end = 20.dp))
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            if (tarea.completada) {
                Text("Estado: Completada")
            } else {
                Text("Estado: Pendiente")
            }

            Spacer(modifier = Modifier.height(10.dp))


            TextButton(
                onClick = {
                    menuEstadoAbierto = true
                }
            ) {
                Text("Cambiar estado")
            }

            DropdownMenu(
                expanded = menuEstadoAbierto,
                onDismissRequest = {
                    menuEstadoAbierto = false
                }
            ) {
                DropdownMenuItem(
                    text = { Text("Marcar como completada") },
                    onClick = {
                        tarea.completada = true
                        menuEstadoAbierto = false
                    }
                )

                DropdownMenuItem(
                    text = { Text("Marcar como pendiente") },
                    onClick = {
                        tarea.completada = false
                        menuEstadoAbierto = false
                    }
                )
            }


            TextButton(
                onClick = {
                    menuPrioridadAbierto = true
                }
            ) {
                Text("Cambiar prioridad")
            }

            DropdownMenu(
                expanded = menuPrioridadAbierto,
                onDismissRequest = {
                    menuPrioridadAbierto = false
                }
            ) {
                DropdownMenuItem(
                    text = { Text("Alta") },
                    onClick = {
                        tarea.prioridad = "Alta"
                        menuPrioridadAbierto = false
                    }
                )

                DropdownMenuItem(
                    text = { Text("Media") },
                    onClick = {
                        tarea.prioridad = "Media"
                        menuPrioridadAbierto = false
                    }
                )

                DropdownMenuItem(
                    text = { Text("Baja") },
                    onClick = {
                        tarea.prioridad = "Baja"
                        menuPrioridadAbierto = false
                    }
                )
            }
        }
    }
}