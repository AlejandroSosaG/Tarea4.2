package com.example.tarea4_2

import android.app.Application
import androidx.room.Room

class ContactoApp : Application(){
    companion object {
        lateinit var database: BaseDatos
    }
    override fun onCreate() {
        super.onCreate()
        database =  Room.databaseBuilder(this, BaseDatos::class.java, "contactos-db").build()
    }
}