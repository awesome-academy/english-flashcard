package com.sunasterisk.englishflashcard.ui.addword

import com.sunasterisk.englishflashcard.R
import com.sunasterisk.englishflashcard.data.model.Dictionary
import com.sunasterisk.englishflashcard.data.repository.DictionaryRepository
import com.sunasterisk.englishflashcard.data.source.OnDataLoadedCallback

class AddWordPresenter(
    private val view: AddWordContract.View,
    private val reponsitory: DictionaryRepository
) : AddWordContract.Presenter {

    override fun addWord(word: Dictionary) {
        reponsitory.addDictionary(word, object : OnDataLoadedCallback<Boolean> {
            override fun onSuccess(data: Boolean) {
                val messageResId =
                    if (data) {
                        R.string.messeage_insert_success
                    } else {
                        R.string.messeage_insert_failed
                    }
                view.notifyMessage(messageResId)
            }

            override fun onFailed(exception: Exception) {
                view.showError(exception)
            }
        })
    }
}
