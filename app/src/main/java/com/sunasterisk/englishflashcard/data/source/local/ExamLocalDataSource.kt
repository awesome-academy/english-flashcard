package com.sunasterisk.englishflashcard.data.source.local

import com.sunasterisk.englishflashcard.data.model.Exam
import com.sunasterisk.englishflashcard.data.source.ExamDataSource
import com.sunasterisk.englishflashcard.data.source.OnDataLoadedCallback
import com.sunasterisk.englishflashcard.data.source.local.base.EmptyInput
import com.sunasterisk.englishflashcard.data.source.local.base.LocalAsyncTask
import com.sunasterisk.englishflashcard.data.source.local.dao.ExamDAO

class ExamLocalDataSource private constructor(private val examDao: ExamDAO) : ExamDataSource.Local {

    override fun getAllExames(callback: OnDataLoadedCallback<List<Exam>>) {
        LocalAsyncTask<EmptyInput, List<Exam>>(callback) {
            examDao.getAllExames()
        }.execute(EmptyInput)
    }

    override fun addExam(exam: Exam, callback: OnDataLoadedCallback<Boolean>) {
        LocalAsyncTask<Exam, Boolean>(callback) {
            examDao.addExam(exam)
        }.execute(exam)
    }

    override fun deleteExam(examId: String, callback: OnDataLoadedCallback<Boolean>) {
        LocalAsyncTask<String, Boolean>(callback) {
            examDao.deleteExam(examId)
        }.execute(examId)
    }

    companion object {
        private var instance: ExamLocalDataSource? = null
        fun getInstance(examDao: ExamDAO): ExamLocalDataSource =
            instance ?: ExamLocalDataSource(examDao).also {
                instance = it
            }
    }
}
