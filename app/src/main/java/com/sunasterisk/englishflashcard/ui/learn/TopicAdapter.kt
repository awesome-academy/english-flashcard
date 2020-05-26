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
    private var clickListener: ClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder =
        TopicViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.topic_item, parent, false)
        )
        { position ->
            clickListener?.onItemClick(topics[position].id)
        }

    override fun getItemCount(): Int = topics.size

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.bindData(topics[position])
    }

    fun updateData(newArrTopics: List<Topic>) {
        topics.clear()
        topics.addAll(newArrTopics)
        notifyDataSetChanged()
    }

    fun setOnClickListener(clickListener: ClickListener?) {
        this.clickListener = clickListener
    }

    class TopicViewHolder(itemView: View, private val onClickListener: (Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onClickListener(adapterPosition)
            }
        }

        fun bindData(topics: Topic) {
            itemView.textViewNameTopic.text = topics.name
            Glide.with(itemView).load(topics.image).into(itemView.imageTopic)
        }
    }

    interface ClickListener {
        fun onItemClick(id: Int)
    }
}
