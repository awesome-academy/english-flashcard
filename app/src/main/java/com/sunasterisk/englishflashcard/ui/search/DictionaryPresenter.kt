package com.sunasterisk.englishflashcard.ui.search

import com.sunasterisk.englishflashcard.data.model.Dictionary
import com.sunasterisk.englishflashcard.data.repository.DictionaryRepository
import com.sunasterisk.englishflashcard.data.source.OnDataLoadedCallback

class DictionaryPresenter(
    private val view: DictionaryContract.View,
    private val repositoryDictionary: DictionaryRepository
) : DictionaryContract.Presenter {

    override fun getDictionaries(nameEnglish: String) {
        repositoryDictionary.searchDictionaies(nameEnglish,
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
