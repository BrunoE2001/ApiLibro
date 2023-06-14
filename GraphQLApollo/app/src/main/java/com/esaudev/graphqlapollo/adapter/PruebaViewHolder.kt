package com.esaudev.graphqlapollo.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
//import com.bumptech.glide.Glide
import com.esaudev.graphqlapollo.Detalles
import com.esaudev.graphqlapollo.databinding.ItemPruebaBinding

class PruebaViewHolder (view: View): RecyclerView.ViewHolder(view) {

    val binding = ItemPruebaBinding.bind(view)

    fun render (m: Detalles, onClickListener: (Detalles) -> Unit, onClickDeleted: (Int) -> Unit) {
        binding.prueba.text = m.detailsBookTitle
        binding.pruebaPrecio.text = m.detailsBookPrice
        Glide.with(binding.imgPrueba.context).load(m.detailsBookPhoto).into(binding.imgPrueba)

        binding.btnDelete.setOnClickListener { onClickDeleted(adapterPosition) }

        itemView.setOnClickListener{
            onClickListener(m)
        }

    }
}