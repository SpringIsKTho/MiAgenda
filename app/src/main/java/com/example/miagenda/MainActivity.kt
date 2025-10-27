package com.example.miagenda

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val contactos = mutableListOf<Contacto>(
        Contacto("Saif", 689778974),
        Contacto("Ivan", 689918492),
        Contacto("Gon", 692986431)
    )
    lateinit var listadoContactos : RecyclerView
    lateinit var fabNuevoContacto : FloatingActionButton

    lateinit var contactosAdapter : ContactosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initComponents()
        initUI()
        initListeners()
    }

    private fun initUI() {
        contactosAdapter = ContactosAdapter(contactos)
        listadoContactos.layoutManager = LinearLayoutManager(this)
        listadoContactos.adapter = contactosAdapter
    }

    fun initComponents(){
        listadoContactos = findViewById(R.id.rvContactos)
        fabNuevoContacto = findViewById(R.id.fabNuevoContacto)
    }

    fun initListeners(){
        fabNuevoContacto.setOnClickListener {
            showDialog()
        }
    }

    fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_contacto)
        val etContacto : EditText = dialog.findViewById<EditText>(R.id.etContacto)
        val etNumero : EditText = dialog.findViewById<EditText>(R.id.etNumero)
        val buttonAddContacto : Button = dialog.findViewById<Button>(R.id.buttonAddContacto)
        buttonAddContacto.setOnClickListener {
            val ContactoActual = etContacto.text.toString()
            val NumeroActual = etNumero.text.toString()
            if (ContactoActual.isNotEmpty() && NumeroActual.isNotEmpty()){
                contactos.add(Contacto(ContactoActual, NumeroActual.toInt()))
                updateContacto()
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    fun updateContacto(){
        contactosAdapter.notifyDataSetChanged()
    }
}