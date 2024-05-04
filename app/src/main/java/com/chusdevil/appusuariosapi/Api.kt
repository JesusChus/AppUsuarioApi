package com.chusdevil.appusuariosapi

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("users")
    fun traerUsuarios() : Call<TodosLosUsuarios>

    @GET("users/{id}")
    fun traerUnSoloPost(@Path("id") id: Int) : Call<UnUsuario>
}