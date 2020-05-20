package com.sunasterisk.englishflashcard.data.repository

import com.sunasterisk.englishflashcard.data.model.Dictionary
import com.sunasterisk.englishflashcard.data.source.DictionaryDataSource
import com.sunasterisk.englishflashcard.data.source.OnDataLoadedCallback

class DictionaryRepository(private val localDataSource: DictionaryDataSource.Local) :
    DictionaryDataSource.Local {

    override fun getAllDictionaries(
        topicId: String,
        callback: OnDataLoadedCallback<List<Dictionary>>
    ) {
        localDataSource.getAllDictionaries(topicId, callback)
    }

    override fun addDictionary(dictionary: Dictionary, callback: OnDataLoadedCallback<Boolean>) {
        localDataSource.addDictionary(dictionary, callback)
    }

    override fun deleteDictionary(dictionaryId: String, callback: OnDataLoadedCallback<Boolean>) {
        localDataSource.deleteDictionary(dictionaryId, callback)
    }

    override fun searchDictionaies(
        nameEnglish: String,
        callback: OnDataLoadedCallback<List<Dictionary>>
    ) {
        localDataSource.searchDictionaies(nameEnglish, callback)
    }

    companion object {
        private var instance: DictionaryRepository? = null
        fun getInstance(local: DictionaryDataSource.Local) =
            instance ?: DictionaryRepository(local).also { instance = it }
    }
}
