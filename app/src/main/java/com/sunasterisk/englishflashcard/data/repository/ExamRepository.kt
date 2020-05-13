package com.sunasterisk.englishflashcard.data.repository

import com.sunasterisk.englishflashcard.data.model.Exam
import com.sunasterisk.englishflashcard.data.source.ExamDataSource
import com.sunasterisk.englishflashcard.data.source.OnDataLoadedCallback

class ExamRepository(private val localDataSource: ExamDataSource.Local) : ExamDataSource.Local {

    override fun getAllExames(callback: OnDataLoadedCallback<List<Exam>>) {
        localDataSource.getAllExames(callback)
    }

    override fun addExam(exam: Exam, callback: OnDataLoadedCallback<Boolean>) {
        localDataSource.addExam(exam, callback)
    }

    override fun deleteExam(examId: String, callback: OnDataLoadedCallback<Boolean>) {
        localDataSource.deleteExam(examId, callback)
    }

    companion object {
        private var instance: ExamRepository? = null
        fun getInstance(local: ExamDataSource.Local) =
            instance ?: ExamRepository(local).also { instance = it }
    }
}
