package com.example.miagenda

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactosViewHolder(view : View): RecyclerView.ViewHolder(view) {
    private val tvNombre : TextView = view.findViewById(R.id.tvNombre)
    private val tvNumero : TextView = view.findViewById(R.id.tvNumero)

    fun render(contacto : Contacto){
        tvNombre.text = contacto.nombre
        tvNumero.text = contacto.telefono.toString()
    }
}