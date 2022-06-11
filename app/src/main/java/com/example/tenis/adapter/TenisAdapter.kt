package com.example.tenis.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tenis.databinding.TenisFilaBinding
import com.example.tenis.model.Tenis
import com.example.tenis.ui.tenis.TenisFragmentDirections

class TenisAdapter : RecyclerView.Adapter<TenisAdapter.TenisViewHolder>(){
    //LOS ADAPTER TIENEN LA MISMA ESTRUCTURA SIEMPRE

    //LISTA PARA GESTIONAR LA INFORMACION DE LOS LUGARES
    private var lista = emptyList<Tenis>()

    inner class TenisViewHolder(private val itemBinding: TenisFilaBinding)
        : RecyclerView.ViewHolder (itemBinding.root){

        fun dibuja(tenis: Tenis){
            itemBinding.tvMarca.text = tenis.marca
            itemBinding.tvModelo.text = tenis.modelo
            itemBinding.tvTalla.text = tenis.talla
            itemBinding.tvPrecio.text = tenis.precio

           /* itemBinding.vistaFila.setOnClickListener{
                val accion =  TenisFragmentDirections
                    .actionNavLugarToUpdateLugarFragment(tenis)
                itemView.findNavController().navigate(accion)
            }*/
        }
    }

    //ACA SE VA CREAR UNA "CAJITA" DEL RECICLADOR... UNA FILA... SOLO LA ESTRUCTURA
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TenisViewHolder {
        val itemBinding =
            TenisFilaBinding.inflate(LayoutInflater.from(parent.context),
                parent,false)
        return  TenisViewHolder(itemBinding)
    }

    //ACA SE VA A SOLICITAR "DIBUJAR" UNA CAJITA, SEGUN EL ELEMENTO DE LA LISTA
    override fun onBindViewHolder(holder: TenisViewHolder, position: Int) {
        val tenis = lista[position]
        holder.dibuja(tenis)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun setData(tenis : List<Tenis>){
        lista = tenis
        notifyDataSetChanged()
    }

}