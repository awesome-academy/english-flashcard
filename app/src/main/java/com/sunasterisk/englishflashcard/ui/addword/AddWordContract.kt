package com.sunasterisk.englishflashcard.ui.addword

import com.sunasterisk.englishflashcard.data.model.Dictionary

interface AddWordContract {

    interface View {
        fun notifyMessage(messageResId: Int)
        fun showError(exception: Exception)
    }

    interface Presenter {
        fun addWord(word: Dictionary)
    }
}
