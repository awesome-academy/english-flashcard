package com.sunasterisk.englishflashcard.data.source.local

import com.sunasterisk.englishflashcard.data.model.Topics
import com.sunasterisk.englishflashcard.data.source.OnDataLoadedCallback
import com.sunasterisk.englishflashcard.data.source.TopicsDataSource
import com.sunasterisk.englishflashcard.data.source.local.base.EmptyInput
import com.sunasterisk.englishflashcard.data.source.local.base.LocalAsyncTask
import com.sunasterisk.englishflashcard.data.source.local.dao.TopicsDAO

class TopicsLocalDataSource private constructor(private val topicsDao: TopicsDAO) :
    TopicsDataSource.Local {

    override fun getAllTopics(callback: OnDataLoadedCallback<List<Topics>>) {
        LocalAsyncTask<EmptyInput, List<Topics>>(callback) {
            topicsDao.getAllTopics()
        }.execute(EmptyInput)
    }

    override fun addTopic(topic: Topics, callback: OnDataLoadedCallback<Boolean>) {
        LocalAsyncTask<Topics, Boolean>(callback) {
            topicsDao.addTopic(topic)
        }.execute(topic)
    }

    override fun deleteTopic(topicId: String, callback: OnDataLoadedCallback<Boolean>) {
        LocalAsyncTask<String, Boolean>(callback) {
            topicsDao.deleteTopic(topicId)
        }.execute(topicId)
    }

    companion object {
        private var instance: TopicsLocalDataSource? = null
        fun getInstance(topicDao: TopicsDAO): TopicsLocalDataSource =
            instance ?: TopicsLocalDataSource(topicDao).also {
                instance = it
            }
    }
}
