package com.sunasterisk.englishflashcard.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.data.model.Dictionary
import kotlinx.android.synthetic.main.dictionary_item.view.*

class DictionaryAdapter : RecyclerView.Adapter<DictionaryAdapter.DictionaryViewHolder>() {

    private val dictionaries = mutableListOf<Dictionary>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryViewHolder =
        DictionaryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.dictionary_item, parent, false)
        )

    override fun getItemCount(): Int = dictionaries.size

    override fun onBindViewHolder(holder: DictionaryViewHolder, position: Int) {
        holder.bindData(dictionaries[position])
    }

    fun updateData(newArrDictionares: List<Dictionary>) {
        dictionaries.clear()
        dictionaries.addAll(newArrDictionares)
        notifyDataSetChanged()
    }

    class DictionaryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(dictionary: Dictionary) {
            itemView.textEnglish.text = dictionary.word
            itemView.textSpelling.text = dictionary.spelling
            itemView.textVietnam.text = dictionary.translate
        }
    }
}
