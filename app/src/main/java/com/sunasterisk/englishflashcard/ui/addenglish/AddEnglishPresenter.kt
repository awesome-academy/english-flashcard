package com.sunasterisk.englishflashcard.ui.addenglish

import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.data.model.Topic
import com.sunasterisk.englishflashcard.data.repository.TopicsRepository
import com.sunasterisk.englishflashcard.data.source.OnDataLoadedCallback

class AddEnglishPresenter(
    private val view: AddEnglishContract.View,
    private val repositoryTopic: TopicsRepository
) : AddEnglishContract.Presenter {

    override fun addTopic(topic: Topic) {
        repositoryTopic.addTopic(topic, object : OnDataLoadedCallback<Boolean> {
            override fun onSuccess(data: Boolean) {
                if (data == true) {
                    view.notifyMessage(R.string.messeage_insert_success)
                } else {
                    view.notifyMessage(R.string.messeage_insert_failed)
                }
            }

            override fun onFailed(exception: Exception) {
                view.showError(exception)
            }
        })
    }

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
