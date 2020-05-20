package com.sunasterisk.englishflashcard.ui.learnandsearch

import com.sunasterisk.englishflashcard.data.model.Topic
import java.lang.Exception

interface TopicContract {

    interface View {
        fun showTopics(data: List<Topic>)
        fun showError(exception: Exception)
    }

    interface Presenter {
        fun getAllTopics()
    }
}
