package com.sunasterisk.englishflashcard.data.source.local

import com.sunasterisk.englishflashcard.data.model.Dictionary
import com.sunasterisk.englishflashcard.data.source.DictionaryDataSource
import com.sunasterisk.englishflashcard.data.source.OnDataLoadedCallback
import com.sunasterisk.englishflashcard.data.source.local.base.EmptyInput
import com.sunasterisk.englishflashcard.data.source.local.base.LocalAsyncTask
import com.sunasterisk.englishflashcard.data.source.local.dao.DictionaryDAO

class DictionaryLocalDataSource private constructor(private val dictionaryDAO: DictionaryDAO) :
    DictionaryDataSource.Local {

    override fun getAllDictionaries(
        topicId: String,
        callback: OnDataLoadedCallback<List<Dictionary>>
    ) {
        LocalAsyncTask<EmptyInput, List<Dictionary>>(callback) {
            dictionaryDAO.getAllDictionaries(topicId)
        }.execute(EmptyInput)
    }

    override fun addDictionary(dictionary: Dictionary, callback: OnDataLoadedCallback<Boolean>) {
        LocalAsyncTask<Dictionary, Boolean>(callback) {
            dictionaryDAO.addDictionary(dictionary)
        }.execute(dictionary)
    }

    override fun deleteDictionary(dictionaryId: String, callback: OnDataLoadedCallback<Boolean>) {
        LocalAsyncTask<String, Boolean>(callback) {
            dictionaryDAO.deleteDictionary(dictionaryId)
        }.execute(dictionaryId)
    }

    companion object {
        private var instance: DictionaryLocalDataSource? = null
        fun getInstance(dictionaryDao: DictionaryDAO): DictionaryLocalDataSource =
            instance ?: DictionaryLocalDataSource(dictionaryDao).also {
                instance = it
            }
    }
}
