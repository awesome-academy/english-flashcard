package com.sunasterisk.englishflashcard.ui.learn

import com.sunasterisk.englishflashcard.data.model.Topic
import java.lang.Exception

interface TopicContract {

    interface View {
        fun showTopics(topics: List<Topic>)
        fun showError(exception: Exception)
    }

    interface Presenter {
        fun getAllTopics()
    }
}
