package com.sunasterisk.englishflashcard.data.repository

import com.sunasterisk.englishflashcard.data.model.Topics
import com.sunasterisk.englishflashcard.data.source.OnDataLoadedCallback
import com.sunasterisk.englishflashcard.data.source.TopicsDataSource

class TopicsRepository(private val localDataSource: TopicsDataSource.Local) :
    TopicsDataSource.Local {

    override fun getAllTopics(callback: OnDataLoadedCallback<List<Topics>>) {
        localDataSource.getAllTopics(callback)
    }

    override fun addTopic(topic: Topics, callback: OnDataLoadedCallback<Boolean>) {
        localDataSource.addTopic(topic, callback)
    }

    override fun deleteTopic(topicId: String, callback: OnDataLoadedCallback<Boolean>) {
        localDataSource.deleteTopic(topicId, callback)
    }

    companion object {
        private var instance: TopicsRepository? = null
        fun getInstance(local: TopicsDataSource.Local) =
            instance ?: TopicsRepository(local).also { instance = it }
    }
}
