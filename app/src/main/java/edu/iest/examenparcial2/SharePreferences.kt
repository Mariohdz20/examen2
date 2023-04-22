package edu.iest.examenparcial2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SharePreferences : AppCompatActivity() {
    private var save: FloatingActionButton? = null
    private var etNombre: EditText? = null
    private var etNombreGato: EditText? = null
    private var etEdadGato: EditText? = null

    fun inicializarVistas() {
        etEdadGato = findViewById(R.id.etEdadGato)
        etNombre = findViewById(R.id.etNombre)
        etNombreGato  = findViewById(R.id.etNombreGato)
    }

    fun guardarConfiguracion() {
        val preferencias = getSharedPreferences("PREFERENCIAS", MODE_PRIVATE)
        val editor = preferencias.edit()
        editor.putString("NAME", etNombre?.text.toString())
        editor.putInt("EDAD", etEdadGato?.text.toString().toInt())
        editor.putString("DINERO", etNombreGato?.text.toString())
        editor.apply()
        Toast.makeText(this,"se guardaron sus datos", Toast.LENGTH_LONG).show()
    }

    fun getDefaultConfig() {
        val preferencias = getSharedPreferences("PREFERENCIAS", MODE_PRIVATE)

        val name = preferencias?.getString("NAME", "").toString()
        val namegato = preferencias?.getString("NAMECAT", "").toString()
        val edad = preferencias?.getInt("EDAD",0)

        etNombre?.setText(name)
        etNombreGato?.setText(namegato)

        if (edad == 0) {
            etEdadGato?.setText("")
        }else {
            etEdadGato?.setText(edad.toString())
        }
    }
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_preferences)
        inicializarVistas()
        save =findViewById(R.id.save)

        save?.setOnClickListener {
            guardarConfiguracion()
        }

    }
}