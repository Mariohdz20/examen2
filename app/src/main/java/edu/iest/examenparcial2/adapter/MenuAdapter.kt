package edu.iest.examenparcial2.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import edu.iest.examenparcial2.R
import edu.iest.examenparcial2.SharePreferences
import edu.iest.examenparcial2.models.OpcionMenu


class MenuAdapter(opciones: ArrayList<OpcionMenu>, context: Context):
    RecyclerView.Adapter<MenuAdapter.ContenedorDeVista>() {

    val innerOpciones: ArrayList<OpcionMenu> = opciones
    val innerContext = context
    val prefer = context.getSharedPreferences("Pref", AppCompatActivity.MODE_PRIVATE)

    inner class ContenedorDeVista(view: View): RecyclerView.ViewHolder(view) {
    val tvTexto: TextView
    val ivOpcion: ImageView

    init {
        tvTexto = view.findViewById(R.id.tvTexto)
        ivOpcion = view.findViewById(R.id.ivOpcion)

        tvTexto.setOnClickListener {
            Toast.makeText(tvTexto.context, "${tvTexto.text}", Toast.LENGTH_LONG).show()
        }


            ivOpcion.setOnClickListener {
                val irSharePreferences = Intent(view.context, SharePreferences::class.java)
                view.context.startActivity(irSharePreferences)

        }

    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContenedorDeVista {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_elemento_menu, parent, false)

        return  ContenedorDeVista(view)
    }

    override fun getItemCount(): Int {
        return innerOpciones.size
    }

    override fun onBindViewHolder(holder: ContenedorDeVista, position: Int) {
        val opcion = innerOpciones.get(position)
        holder.tvTexto.text = opcion.nombre
        holder.ivOpcion.setImageResource(opcion.imagen)

    }
}