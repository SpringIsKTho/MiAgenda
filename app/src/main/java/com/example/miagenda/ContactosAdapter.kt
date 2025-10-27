package com.example.miagenda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactosAdapter(private val contacto: List<Contacto>) : RecyclerView.Adapter<ContactosViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contacto, parent, false)
        return ContactosViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ContactosViewHolder,
        position: Int
    ) {
        holder.render(contacto[position])
    }

    override fun getItemCount(): Int {
        return contacto.size
    }
}