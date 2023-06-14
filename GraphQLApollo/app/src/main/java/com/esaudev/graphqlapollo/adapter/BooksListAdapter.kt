package com.esaudev.graphqlapollo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.esaudev.graphqlapollo.CharactersListQuery
import com.esaudev.graphqlapollo.databinding.ItemCharacterBinding

class BooksListAdapter(
    onClickListener1: CharactersListQuery.Book.Companion,
    private val onClickListener: (CharactersListQuery.Book) -> Unit
): ListAdapter<CharactersListQuery.Book, BaseListViewHolder<*>>(DiffUtilCallback)  {

    private object DiffUtilCallback : DiffUtil.ItemCallback<CharactersListQuery.Book>() {
        override fun areItemsTheSame(oldItem: CharactersListQuery.Book, newItem: CharactersListQuery.Book): Boolean = oldItem.author == newItem.author
        override fun areContentsTheSame(oldItem: CharactersListQuery.Book, newItem: CharactersListQuery.Book): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListViewHolder<*> {
        val itemBinding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BindViewHolder(itemBinding, onClickListener)
    }

    override fun onBindViewHolder(holder: BaseListViewHolder<*>, position: Int) {
        when (holder) {
            is BindViewHolder -> holder.bind(getItem(position), position)
        }
    }

    inner class BindViewHolder(private val binding: ItemCharacterBinding, private val onClickListener: (CharactersListQuery.Book) -> Unit) : BaseListViewHolder<CharactersListQuery.Book>(binding.root) {

        override fun bind(item: CharactersListQuery.Book, position: Int) = with(binding) {

            txtBookTitle.text = item.title
            txtAuthor.text = item.author
            txtPrice.text = item.precio.toString()
            Glide.with(ivBook.context).load(item.imagen).into(ivBook)

            itemView.setOnClickListener{
                onClickListener(item)

            }
        }

    }
}