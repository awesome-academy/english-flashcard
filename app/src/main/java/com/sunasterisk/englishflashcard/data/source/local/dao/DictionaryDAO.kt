package com.sunasterisk.englishflashcard.data.source.local.dao

import com.sunasterisk.englishflashcard.data.model.Dictionary

interface DictionaryDAO {
    fun getAllDictionaries(TopicId: String): List<Dictionary>
    fun addDictionary(dictionary: Dictionary): Boolean
    fun deleteDictionary(dictionaryId: String): Boolean
    fun searchDictionaies(nameEnglish: String): List<Dictionary>
}
