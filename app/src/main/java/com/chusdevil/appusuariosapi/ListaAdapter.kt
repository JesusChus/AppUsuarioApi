package com.chusdevil.appusuariosapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter

class ListaAdapter(val listaMutable: MutableList<ElementoDeLista>, private val onClickSelected:(Int) -> Unit) : Adapter<ElementoViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolder {
        val elementoXml =
            LayoutInflater.from(parent.context).inflate(R.layout.elemento_lista, parent, false)
        val elemento = ElementoViewHolder(elementoXml)
        return elemento
    }

    override fun getItemCount(): Int {
        return listaMutable.size
    }

    override fun onBindViewHolder(holder: ElementoViewHolder, position: Int) {
        val valores: ElementoDeLista = listaMutable[position]
        holder.datosElementoLista(valores.imagenUsuario, valores.nombreUsuario, valores.id, onClickSelected)



    }

}