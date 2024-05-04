package com.chusdevil.appusuariosapi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chusdevil.appusuariosapi.UsuarioDetalles.Companion.ID
//import com.chusdevil.appusuariosapi.UsuarioDetalles.Companion.EXTRA_ID
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(){

    private val listaMutable = mutableListOf<ElementoDeLista>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

        val lista = findViewById<RecyclerView>(R.id.rvLista)
        val adapter = ListaAdapter(listaMutable){onClick(it)}
        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adapter

        val retrofit = inicializarRetrofit()
        val api = retrofit.create(Api::class.java)
        api.traerUsuarios().enqueue(object : Callback<TodosLosUsuarios>{
            override fun onResponse(p0: Call<TodosLosUsuarios>, p1: Response<TodosLosUsuarios>) {
                val todo = p1.body()!!
                todo.users.forEach {
                    listaMutable.add(ElementoDeLista(it.image,it.firstName, it.id))
                }
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(p0: Call<TodosLosUsuarios>, p1: Throwable) {

            }

        })

    }

    fun inicializarRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
     private fun onClick(posicion : Int){
        val intent = Intent(this,UsuarioDetalles::class.java)
        intent.putExtra(ID, posicion)
        startActivity(intent)
    }
}