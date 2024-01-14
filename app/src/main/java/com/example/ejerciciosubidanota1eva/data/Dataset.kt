package com.example.ejerciciosubidanota1eva.data

import com.example.ejerciciosubidanota1eva.R
import com.example.ejerciciosubidanota1eva.model.Moneda

class DataSet {
    companion object{
        val listaMonedas = ArrayList<Moneda>()
        fun obtenerListaCompleta(): ArrayList<Moneda> {

            listaMonedas.add(Moneda("Dollar", R.drawable.dollar))
            listaMonedas.add(Moneda("Euro",R.drawable.euro))
            listaMonedas.add(Moneda("Libra",R.drawable.libra))

            return listaMonedas
        }
    }
}