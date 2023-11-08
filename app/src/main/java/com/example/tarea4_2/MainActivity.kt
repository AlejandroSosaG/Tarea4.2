package com.example.tarea4_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea3_1.Entidad.Contacto
import com.example.tarea4_2.databinding.ActivityMainBinding
import com.example.tarea4_2.databinding.ContactosBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ContactosAdapter
    lateinit var contacto: MutableList<Contacto>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val main = ActivityMainBinding.inflate(layoutInflater)
        val contactos = ContactosBinding.inflate(layoutInflater)
        setContentView(main.root)
        contacto.addAll(listOf(Contacto("Alejandro Sosa García", "123456789", "Hombre"),
            Contacto("Angel Navarro Mesas", "987654321", "Hombre"),
            Contacto("David Bermúdez Alcántara", "666666666", "Hombre"),
            Contacto("Alejandro Mulero Muletas", "000000000", "Hombre"),
            Contacto("Francisco Javier ", "987654321", "Hombre"),
            Contacto("Rubén Lindes ", "612511120", "Hombre"),
            Contacto("David Perea ", "123456789", "Hombre"),
            Contacto("Claudia Mendoza", "666666666", "Mujer"),
            Contacto("Lydia Pérez González", "123456789", "Mujer"),
            Contacto("Carmen Martín Núñez", "987654321", "Mujer"),
            Contacto("Antonio Navarro", "666666666", "Hombre"),
            Contacto("Fernando José Miguel Gómez", "123456789", "Hombre"),
            Contacto("Britany Sanchez Ballón", "987654321", "Mujer"),
            Contacto("Yeray Jimenez", "666666666", "Hombre"),
            Contacto("Juan Manuel Sánchez Moreno", "123456789", "Hombre")))
        getTasks()
    }
    fun getTasks()= runBlocking {       // Corrutina que saca de la base de datos la lista de tareas
        launch {                        // Inicio del hilo
            contacto = ContactoApp.database.taskDao().getAllTasks()    // Se carga la lista de tareas
            setUpRecyclerView(contacto)        // se pasa la lista a la Vista
        }
    }

    fun deleteTask(task: Contacto)= runBlocking{
        launch {
            val position = contacto.indexOf(task)  // Busca la posición de la tarea en la lista...
            ContactoApp.database.taskDao().deleteTask(task) // ... y la borra de la base de datos.
            contacto.remove(task)      // Finalmente, la elimina de la lista
            adapter.notifyItemRemoved(position) // El adaptador notifica que se ha eliminado la tarea
        }
    }
    fun setUpRecyclerView(contactos: List< Contacto>) {    // Método que muestra la vista usando el adaptador
        //adapter = ContactosAdapter(contactos, { {deleteTask(it)})
        //recyclerView = findViewById(R.id.lista)
        //recyclerView.setHasFixedSize(true)
        //recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.adapter = adapter
    }
}