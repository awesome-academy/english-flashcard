package com.sunasterisk.englishflashcard.data.source

import com.sunasterisk.englishflashcard.data.model.Topics

interface TopicsDataSource {
    interface Local {
        fun getAllTopics(callback: OnDataLoadedCallback<List<Topics>>)
        fun addTopic(topic: Topics, callback: OnDataLoadedCallback<Boolean>)
        fun deleteTopic(topicId: String, callback: OnDataLoadedCallback<Boolean>)
    }
}
