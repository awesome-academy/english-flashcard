package com.sunasterisk.englishflashcard.ui.flashcard

import com.sunasterisk.englishflashcard.data.model.Dictionary

interface FlashcardContract {
    interface View {
        fun showDictionaries(data: List<Dictionary>)
        fun showError(exception: Exception)
    }

    interface Presenter {
        fun getAllDictionaries(idTopic: String)
    }
}
