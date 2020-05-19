package com.sunasterisk.englishflashcard.data.source

import com.sunasterisk.englishflashcard.data.model.Topic

interface TopicsDataSource {
    interface Local {
        fun getAllTopics(callback: OnDataLoadedCallback<List<Topic>>)
        fun addTopic(topic: Topic, callback: OnDataLoadedCallback<Boolean>)
        fun deleteTopic(topicId: String, callback: OnDataLoadedCallback<Boolean>)
    }
}
