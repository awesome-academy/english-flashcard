package com.sunasterisk.englishflashcard.data.source

import com.sunasterisk.englishflashcard.data.model.Dictionary

interface DictionaryDataSource {
    interface Local {
        fun getAllDictionaries(topicId: String, callback: OnDataLoadedCallback<List<Dictionary>>)
        fun addDictionary(dictionary: Dictionary, callback: OnDataLoadedCallback<Boolean>)
        fun deleteDictionary(dictionaryId: String, callback: OnDataLoadedCallback<Boolean>)
        fun searchDictionaies(nameEnglish: String, callback: OnDataLoadedCallback<List<Dictionary>>)
    }
}
