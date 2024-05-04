package com.chusdevil.appusuariosapi

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso

class ElementoViewHolder(itemView: View) : ViewHolder(itemView) {
    private val name = itemView.findViewById<TextView>(R.id.nombrePerfil)
    private val image = itemView.findViewById<ImageView>(R.id.imagenPerfil)

    fun datosElementoLista(
        imagen: String,
        nombre: String,
        id: Int,
        onClickSelected:(Int) -> Unit

    ) {
        Picasso.get().load(imagen).into(image)
        name.text = nombre
        itemView.setOnClickListener {
            onClickSelected (id)
        }



    }
}