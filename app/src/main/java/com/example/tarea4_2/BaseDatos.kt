package com.example.tarea4_2

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tarea3_1.Entidad.Contacto

@Database(entities = arrayOf(Contacto :: class), version = 1)
abstract class BaseDatos : RoomDatabase() {
    abstract fun taskDao() : Dao
}