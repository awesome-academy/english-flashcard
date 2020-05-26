package com.sunasterisk.englishflashcard.ui.addtopic

import com.sunasterisk.englishflashcard.data.model.Topic

interface AddTopicContract {

    interface View {
        fun showTopics(topics: List<Topic>)
        fun notifyMessage(messageResId: Int)
        fun showError(exception: Exception)
    }

    interface Presenter {
        fun addTopic(topic: Topic)
        fun getAllTopics()
    }
}
