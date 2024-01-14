package com.example.ejerciciosubidanota1eva


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejerciciosubidanota1eva.adapter.AdaptadorRecycler
import com.example.ejerciciosubidanota1eva.adapter.AdaptadorSpinnerMoneda
import com.example.ejerciciosubidanota1eva.data.DataSet
import com.example.ejerciciosubidanota1eva.databinding.ActivityMainBinding
import com.example.ejerciciosubidanota1eva.model.Moneda
import com.example.ejerciciosubidanota1eva.model.TransaccionMoneda

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorMonedas: AdaptadorSpinnerMoneda
    private lateinit var adaptadorRecycler: AdaptadorRecycler
    private lateinit var listaMonedas: ArrayList<Moneda>
    private val listaTransacciones = ArrayList<TransaccionMoneda>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaMonedas = DataSet.obtenerListaCompleta()
        adaptadorMonedas = AdaptadorSpinnerMoneda(listaMonedas, this)
        binding.monedaOrigen.adapter = adaptadorMonedas
        binding.monedaDestino.adapter = adaptadorMonedas

        adaptadorRecycler = AdaptadorRecycler(listaTransacciones, this)
        binding.recyclerTransacciones.adapter = adaptadorRecycler

        binding.botonCambio.setOnClickListener(this)
        binding.recyclerTransacciones.layoutManager = LinearLayoutManager(this)
        adaptadorRecycler = AdaptadorRecycler(listaTransacciones, this)
        binding.recyclerTransacciones.adapter = adaptadorRecycler
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.botonCambio -> {
                val moneda1: Moneda = binding.monedaOrigen.selectedItem as Moneda
                val moneda2: Moneda = binding.monedaDestino.selectedItem as Moneda

                val monedaOrigen = moneda1
                val monedaDestino = moneda2

                val nuevaTransaccion = TransaccionMoneda(monedaOrigen, monedaDestino)

                adaptadorRecycler.lista.add(nuevaTransaccion)
                adaptadorRecycler.notifyDataSetChanged()

                if (moneda1.nombre.equals("Euro", ignoreCase = true)) {
                    try {
                        val valor: Double = binding.textoCambio.text.toString().toDouble()

                        when (moneda2.nombre) {
                            "Euro" -> {
                                binding.textoCambio.setText((valor * 1).toString())
                            }
                            "Dollar" -> {
                                binding.textoCambio.setText((valor * 1.09).toString())
                            }
                            "Libra" -> {
                                binding.textoCambio.setText((valor * 0.85).toString())
                            }
                        }

                    } catch (e: NumberFormatException) {
                    }
                }
                if (moneda1.nombre.equals("Dollar", ignoreCase = true)) {
                    try {
                        val valor: Double = binding.textoCambio.text.toString().toDouble()

                        when (moneda2.nombre) {
                            "Euro" -> {
                                binding.textoCambio.setText((valor * 0.91).toString())
                            }
                            "Dollar" -> {
                                binding.textoCambio.setText((valor * 1).toString())
                            }
                            "Libra" -> {
                                binding.textoCambio.setText((valor * 0.78).toString())
                            }
                        }

                    } catch (e: NumberFormatException) {
                    }
                }
                if (moneda1.nombre.equals("Libra", ignoreCase = true)) {
                    try {
                        val valor: Double = binding.textoCambio.text.toString().toDouble()

                        when (moneda2.nombre) {
                            "Euro" -> {
                                binding.textoCambio.setText((valor * 1.16).toString())
                            }
                            "Dollar" -> {
                                binding.textoCambio.setText((valor * 1.27).toString())
                            }
                            "Libra" -> {
                                binding.textoCambio.setText((valor * 1).toString())
                            }
                        }

                    } catch (e: NumberFormatException) {
                    }
                }
            }
        }
    }



}

