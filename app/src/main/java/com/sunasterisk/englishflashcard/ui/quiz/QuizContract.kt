package com.sunasterisk.englishflashcard.ui.quiz

import com.sunasterisk.englishflashcard.data.model.Quiz
import java.lang.Exception

interface QuizContract {
    interface View {
        fun showDataWordEnglish(data: List<Quiz>)
        fun showError(exception: Exception)
    }

    interface Presenter {
        fun getDataWordEnglish(idTopic: String)
    }
}
