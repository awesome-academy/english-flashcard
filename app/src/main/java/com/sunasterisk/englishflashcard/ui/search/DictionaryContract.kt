package com.sunasterisk.englishflashcard.ui.search

import com.sunasterisk.englishflashcard.data.model.Dictionary
import java.lang.Exception

interface DictionaryContract {

    interface View {
        fun showDictionaries(dictionaries: List<Dictionary>)
        fun showError(exception: Exception)
    }

    interface Presenter {
        fun getDictionaries(nameEnglish: String)
    }
}
