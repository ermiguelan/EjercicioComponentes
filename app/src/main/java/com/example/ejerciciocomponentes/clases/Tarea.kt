package com.example.ejerciciocomponentes.clases

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Tarea(
    val nombre: String,
    completadaInicial: Boolean,
    prioridadInicial: String) {
    var completada by mutableStateOf(completadaInicial)
    var prioridad by mutableStateOf(prioridadInicial)
}