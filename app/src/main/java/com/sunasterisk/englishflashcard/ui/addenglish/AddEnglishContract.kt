package com.sunasterisk.englishflashcard.ui.addenglish

import com.sunasterisk.englishflashcard.data.model.Topic

interface AddEnglishContract {

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
