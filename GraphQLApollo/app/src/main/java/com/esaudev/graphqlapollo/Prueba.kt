package com.esaudev.graphqlapollo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esaudev.graphqlapollo.adapter.PruebaAdapter
import com.esaudev.graphqlapollo.databinding.ActivityPruebaBinding

class Prueba : AppCompatActivity() {

    private lateinit var binding: ActivityPruebaBinding
    private var mutable: MutableList<Detalles> = DetallesProvider.detallesList
    private lateinit var adapter: PruebaAdapter

    private var suma: Float = 0.0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPruebaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.btnAdd.setOnClickListener { createBook() }


        var bundle :Bundle ?=intent.extras
        var message = bundle!!.getString("title")
        var message2 = bundle!!.getInt("price")
        var message3 = bundle!!.getString("photo")

        val pruebita = Detalles(message.toString(), message2.toString(), message3.toString())

        mutable.add(index = 0, pruebita)
        //adapter.notifyItemInserted(0)


        //______________________________________________________________________________________
        for (item in mutable) {
            println("${item}: $${item.detailsBookPrice}")
            suma += item.detailsBookPrice.toFloat()
        }

        binding.txtPruebaTotal.text = suma.toString()

        initRecyclerView()

        binding.btnConfirm.setOnClickListener {
            val intent = Intent(this, ThanksU::class.java).apply {}
            startActivity(intent)
            mutable.clear()
            finish()
        }
    }

    /*fun createBook() {
        var bundle :Bundle ?=intent.extras
        var message = bundle!!.getString("title")
        var message2 = bundle!!.getString("price")
        var message3 = bundle!!.getString("photo")

        val pruebita = Detalles(message.toString(), message2.toString(), message3.toString())

        mutable.add(index = 0, pruebita)
        //adapter.notifyItemInserted(0)

        //______________________________________________________________________________________-
        var suma: Float = 0.0f
        //suma += message2!!.toFloat()

        for (item in mutable) {
            println("${item}: $${item.detailsBookPrice}")
            suma += item.detailsBookPrice.toFloat()
        }

        binding.txtPruebaTotal.text = suma.toString()
    }*/


    private fun initRecyclerView () {
        adapter = PruebaAdapter(
            mutable = mutable,
            onClickListener = { detalles -> onItemSelected(detalles) },
            onClickDeleted = { position -> onDeletedItem(position) }
        )

        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)

        binding.recyclerViewPrueba.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewPrueba.adapter = adapter

        binding.recyclerViewPrueba.addItemDecoration(decoration)
    }

    private fun onDeletedItem (position: Int) {
        mutable.removeAt(position)
        adapter.notifyItemRemoved(position)

        suma = 0.0f

        for (item in mutable) {
            println("${item}: $${item.detailsBookPrice}")
            suma += item.detailsBookPrice.toFloat()
        }

        binding.txtPruebaTotal.text = suma.toString()
    }

    private fun onItemSelected (detalles: Detalles){
        Toast.makeText(this, detalles.detailsBookPrice, Toast.LENGTH_LONG).show()

        //val intent = Intent(this, Prueba::class.java).apply {}
        //startActivity(intent)
    }




}