package com.example.tarea4_2

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tarea3_1.Entidad.Contacto

@Dao
interface Dao {
    @Query("SELECT * FROM Contacto")
    suspend fun getAllTasks(): MutableList<Contacto>  // Función que devuelve todas las tareas de la base de datos en una lista Mutable.

    @Insert
    suspend fun addTask(taskEntity : Contacto):Long    // Función que añade una tarea, la que se pasa por parámetro, y devuelve el id insertado.                                                          // Devuelve Long porque la cantidad de datos guardada puede ser muy alto.

    @Query("SELECT * FROM Contacto where nombre like :nombre")
    suspend fun getTaskById(nombre: String): Contacto        // Función que busca tareas por id (debe ser Long, no Int)

    @Update
    suspend fun updateTask(task: Contacto):String         // Función que actualiza una tarea y devuelve

    @Delete
    suspend fun deleteTask(task: Contacto):Long         // Función que borra una tarea y devuelve
}