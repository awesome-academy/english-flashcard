package com.sunasterisk.englishflashcard.ui.flashcard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.data.model.Dictionary
import kotlinx.android.synthetic.main.fragment_flashcard_item.view.*

class FlashcardAdapter(
    private val items: List<Dictionary>
) : RecyclerView.Adapter<FlashcardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashcardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_flashcard_item, parent, false)
        return FlashcardViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: FlashcardViewHolder, position: Int) {
        holder.bindData(items[position])
    }

}

class FlashcardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    internal fun bindData(dictionary: Dictionary) {
        itemView.apply {
            textViewEnglish.text = dictionary.word
            textViewEnglishType.text = dictionary.wordType
            textViewSpelling.text = dictionary.spelling
            textViewWordVietnam.text = dictionary.translate
        }
    }
}
