package com.esaudev.graphqlapollo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

//import com.bumptech.glide.Glide

class BookViewMore : AppCompatActivity() {

    lateinit var txtTitle: TextView
    lateinit var txtAuthor: TextView
    lateinit var txtDescription: TextView
    lateinit var ivPhoto: ImageView
    lateinit var txtPrice: TextView

    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_view_more)

        init()

        var bundle :Bundle ?=intent.extras
        var message = bundle!!.getString("title")
        var message2 = bundle!!.getString("author")
        var message3 = bundle!!.getString("description")
        var message4 = bundle!!.getInt("price")
        var message5 = bundle!!.getString("photo")


        txtTitle.text = message
        txtAuthor.text = message2
        txtDescription.text = message3
        Glide.with(ivPhoto.context).load(message5).into(ivPhoto)
        txtPrice.text = message4.toString()

        //Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        btn.setOnClickListener {
            val intent = Intent(this, Prueba::class.java).apply {
                putExtra("title", message)
                putExtra("price", message4)
                putExtra("photo", message5)
            }
            startActivity(intent)
        }
    }

    fun init () {
        txtTitle = findViewById(R.id.txtBookTitleVM)
        txtAuthor = findViewById(R.id.txtBookAuthorVM)
        txtDescription = findViewById(R.id.txtBookDescriptionVM)
        ivPhoto = findViewById(R.id.ivBookVM)
        txtPrice = findViewById(R.id.txtBookPriceVM)

        btn = findViewById(R.id.btnBuy)
    }
}