package com.sunasterisk.englishflashcard.ui.learn

import com.sunasterisk.englishflashcard.data.model.Topic
import com.sunasterisk.englishflashcard.data.repository.TopicsRepository
import com.sunasterisk.englishflashcard.data.source.OnDataLoadedCallback

class TopicPresenter(
    private val view: TopicContract.View,
    private val repositoryTopic: TopicsRepository
) : TopicContract.Presenter {

    override fun getAllTopics() {
        repositoryTopic.getAllTopics(object : OnDataLoadedCallback<List<Topic>> {
            override fun onSuccess(data: List<Topic>) {
                view.showTopics(data)
            }

            override fun onFailed(exception: Exception) {
                view.showError(exception)
            }
        })
    }
}
