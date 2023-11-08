package com.example.tarea3_1.Entidad

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacto")
data class Contacto (
    @PrimaryKey
    val nombre : String = "",
    val tlfn : String = "",
    val genero : String = ""){}