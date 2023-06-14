package com.esaudev.graphqlapollo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.esaudev.graphqlapollo.adapter.BooksListAdapter
import com.esaudev.graphqlapollo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("NotifyDataSetChanged")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: BooksViewModel by viewModels()

    //private lateinit var arrayList: ArrayList<CharactersListQuery.Book>

    private lateinit var charactersListAdapter: BooksListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        charactersListAdapter = BooksListAdapter(CharactersListQuery.Book) { books ->
            onItemSelected(
                books
            )
        }

        binding.charactersList.apply { adapter = charactersListAdapter }
        observeData()
        viewModel.queryCharactersList()
    }

    private fun observeData() {
        viewModel.charactersList.observe(this) { response ->
            when (response) {
                is ViewState.Success -> {
                    if (response.value?.data?.books?.size == 0) {
                        charactersListAdapter.submitList(emptyList())
                        return@observe
                    }
                    val results = response.value?.data?.books
                    charactersListAdapter.submitList(results)
                }
                else -> Unit
            }
        }
    }

    private fun onItemSelected (item: CharactersListQuery.Book){
        //Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()

        val intent = Intent(this, BookViewMore::class.java).apply {
            //Se pasan los datos a la siguiente activity
            putExtra("title", item.title)
            putExtra("author", item.author)
            putExtra("description", item.descripcion)
            putExtra("photo", item.imagen)
            putExtra("price", item.precio)
        }
        startActivity(intent)
    }

}