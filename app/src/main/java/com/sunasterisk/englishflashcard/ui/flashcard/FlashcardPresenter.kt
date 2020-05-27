package com.sunasterisk.englishflashcard.ui.flashcard

import com.sunasterisk.englishflashcard.data.model.Dictionary
import com.sunasterisk.englishflashcard.data.repository.DictionaryRepository
import com.sunasterisk.englishflashcard.data.source.OnDataLoadedCallback

class FlashcardPresenter(
    private val view: FlashcardContract.View,
    private val repositoryDictionary: DictionaryRepository
) : FlashcardContract.Presenter {

    override fun getAllDictionaries(idTopic: String) {
        repositoryDictionary.getAllDictionaries(idTopic,
            object : OnDataLoadedCallback<List<Dictionary>> {
                override fun onSuccess(data: List<Dictionary>) {
                    view.showDictionaries(data)
                }

                override fun onFailed(exception: Exception) {
                    view.showError(exception)
                }
            })
    }
}
