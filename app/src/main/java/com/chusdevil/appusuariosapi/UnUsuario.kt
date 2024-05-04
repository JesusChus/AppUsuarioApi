package com.chusdevil.appusuariosapi

data class UnUsuario(
    val image: String,
    val firstName: String,
    val lastName: String,
    val hair: ColorPelo
)

data class ColorPelo(
    val color: String
)


