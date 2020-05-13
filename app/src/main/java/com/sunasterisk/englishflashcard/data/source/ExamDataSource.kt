package com.sunasterisk.englishflashcard.data.source

import com.sunasterisk.englishflashcard.data.model.Exam

interface ExamDataSource {
    interface Local {
        fun getAllExames(callback: OnDataLoadedCallback<List<Exam>>)
        fun addExam(exam: Exam, callback: OnDataLoadedCallback<Boolean>)
        fun deleteExam(examId: String, callback: OnDataLoadedCallback<Boolean>)
    }
}
