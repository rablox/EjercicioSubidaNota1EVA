package com.example.ejerciciosubidanota1eva.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciosubidanota1eva.R
import com.example.ejerciciosubidanota1eva.model.TransaccionMoneda
import com.google.android.material.snackbar.Snackbar

class AdaptadorRecycler(
    var lista: ArrayList<TransaccionMoneda>,
    var contexto: Context
) : RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val transaccion = lista[position]
        holder.imagenMonedaOrigen.setImageResource(transaccion.monedaOrigen.imagen)
        holder.imagenMonedaDestino.setImageResource(transaccion.monedaDestino.imagen)

        holder.boton.setOnClickListener {
        }
        holder.itemView.setOnClickListener {
            val textoSnackBar = "${transaccion.monedaOrigen.nombre} son ${transaccion.monedaDestino.nombre}"
            Snackbar.make(holder.itemView, textoSnackBar, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        var imagenMonedaOrigen: ImageView = item.findViewById(R.id.imagen_moneda_origen)
        var imagenMonedaDestino: ImageView = item.findViewById(R.id.imagen_moneda_destino)
        var boton: Button = item.findViewById(R.id.boton_detalles)
    }
}