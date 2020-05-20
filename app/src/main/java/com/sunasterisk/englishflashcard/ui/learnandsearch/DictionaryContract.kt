package com.sunasterisk.englishflashcard.ui.learnandsearch

import com.sunasterisk.englishflashcard.data.model.Dictionary
import java.lang.Exception

interface DictionaryContract {

    interface View {
        fun showDictionaries(data: List<Dictionary>)
        fun showError(exception: Exception)
    }

    interface Presenter {
        fun getDictionaries(nameEnglish: String)
    }
}
