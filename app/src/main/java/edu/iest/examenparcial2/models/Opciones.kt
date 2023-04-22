package edu.iest.examenparcial2.models

import edu.iest.examenparcial2.R

class Opciones {

    fun getOpciones(): ArrayList<OpcionMenu>{

        val opcines: ArrayList<OpcionMenu> = arrayListOf()

        opcines.add(
            OpcionMenu("Gatos", R.drawable.gatoboton)
        )

        opcines.add(
            OpcionMenu("Perfil", R.drawable.usuarioboton)
        )

        opcines.add(
            OpcionMenu("Configuracion", R.drawable.configurarboton)
        )

        opcines.add(
            OpcionMenu("Apagar", R.drawable.apagarboton)
        )


        return opcines
    }
}