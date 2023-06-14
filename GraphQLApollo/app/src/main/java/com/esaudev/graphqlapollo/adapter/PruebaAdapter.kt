package com.esaudev.graphqlapollo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.esaudev.graphqlapollo.*

class PruebaAdapter (private val mutable: List<Detalles>, private val onClickListener: (Detalles) -> Unit, private val onClickDeleted:(Int) -> Unit) : RecyclerView.Adapter<PruebaViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PruebaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PruebaViewHolder(layoutInflater.inflate(R.layout.item_prueba, parent, false))
    }

    override fun onBindViewHolder(holder: PruebaViewHolder, position: Int) {
        val item = mutable[position]
        holder.render(item, onClickListener, onClickDeleted)
    }

    override fun getItemCount(): Int = mutable.size
}