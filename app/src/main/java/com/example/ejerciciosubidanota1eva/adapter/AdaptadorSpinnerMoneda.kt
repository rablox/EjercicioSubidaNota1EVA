package com.example.ejerciciosubidanota1eva.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.ejerciciosubidanota1eva.R
import com.example.ejerciciosubidanota1eva.model.Moneda


class AdaptadorSpinnerMoneda(var lista: ArrayList<Moneda>, var contexto: Context) : BaseAdapter() {


    override fun getCount(): Int {
        return lista.size;
    }

    override fun getItem(position: Int): Moneda {
        return lista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun addMoneda(moneda: Moneda) {
        lista.add(moneda)
        notifyDataSetChanged()
    }

    fun cambiarListaMonedas(listaNueva: ArrayList<Moneda>) {
        lista.clear()
        lista.addAll(listaNueva)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?):
            View {
        val vista = LayoutInflater.from(contexto)
            .inflate(R.layout.item_moneda, parent, false)

        val moneda = lista[position]
        val textoMoneda = vista.findViewById<TextView>(R.id.texto_moneda)
        val imagenMoneda = vista.findViewById<ImageView>(R.id.imagen_moneda)
        textoMoneda.text = moneda.nombre
        imagenMoneda.setImageResource(moneda.imagen)



        return vista;


    }
}
