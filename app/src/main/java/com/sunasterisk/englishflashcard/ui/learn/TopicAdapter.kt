package com.sunasterisk.englishflashcard.ui.learn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.data.model.Topic
import kotlinx.android.synthetic.main.topic_item.view.*

class TopicAdapter : RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    private val topics = mutableListOf<Topic>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder =
        TopicViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.topic_item, parent, false)
        )

    override fun getItemCount(): Int = topics.size

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.bindData(topics[position])
    }

    fun updateData(newArrTopics: List<Topic>) {
        topics.clear()
        topics.addAll(newArrTopics)
        notifyDataSetChanged()
    }

    class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(topics: Topic) {
            itemView.textViewNameTopic.text = topics.name
            Glide.with(itemView).load(topics.image).into(itemView.imageTopic)
        }
    }
}
