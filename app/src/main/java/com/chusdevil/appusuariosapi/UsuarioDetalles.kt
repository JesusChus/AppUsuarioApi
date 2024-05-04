package com.chusdevil.appusuariosapi

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class UsuarioDetalles : AppCompatActivity() {

    companion object{
        const val ID = "nombre"
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario_detalles)

        var persona = findViewById<ImageView>(R.id.ivUsuario)
        var nombre = findViewById<TextView>(R.id.tvNombre)
        var apellido = findViewById<TextView>(R.id.tvApellido)
        var colorPelo = findViewById<TextView>(R.id.colorPelo)
        val id  = intent.getIntExtra(ID,0)

        Log.d("jesus","${id}" )

        val retrofit = inicializarRetrofit()
        val api =retrofit.create(Api::class.java)
        api.traerUnSoloPost(id).enqueue(object : Callback<UnUsuario>{
            override fun onResponse(p0: Call<UnUsuario>, p1: Response<UnUsuario>) {
                val perfil = p1.body()!!
                Picasso.get().load(perfil.image).into(persona)
                nombre.text = perfil.firstName
                apellido.text = perfil.lastName
                colorPelo.text = "Su cabello es color: ${perfil.hair.color}"
            }

            override fun onFailure(p0: Call<UnUsuario>, p1: Throwable) {

            }

        })

    }


    fun inicializarRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
//    private fun imagenes(unUsuario: UnUsuario) {
//        Picasso.get().load(unUsuario.image).into(image)
//    }
}