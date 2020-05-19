package com.sunasterisk.englishflashcard.data.source.local

import com.sunasterisk.englishflashcard.data.model.ExamDetail
import com.sunasterisk.englishflashcard.data.source.ExamDetailsDataSource
import com.sunasterisk.englishflashcard.data.source.OnDataLoadedCallback
import com.sunasterisk.englishflashcard.data.source.local.base.EmptyInput
import com.sunasterisk.englishflashcard.data.source.local.base.LocalAsyncTask
import com.sunasterisk.englishflashcard.data.source.local.dao.ExamDetailsDAO

class ExamDetailsLocalDataSource private constructor(private val examDetailsDao: ExamDetailsDAO) :
    ExamDetailsDataSource.Local {

    override fun getAllExamDetails(
        examId: String,
        callback: OnDataLoadedCallback<List<ExamDetail>>
    ) {
        LocalAsyncTask<EmptyInput, List<ExamDetail>>(callback) {
            examDetailsDao.getAllExamDetails(examId)
        }.execute(EmptyInput)
    }

    override fun addExamDetail(examDetail: ExamDetail, callback: OnDataLoadedCallback<Boolean>) {
        LocalAsyncTask<ExamDetail, Boolean>(callback) {
            examDetailsDao.addExamDetail(examDetail)
        }.execute(examDetail)
    }

    override fun deleteExamDetail(
        examDetailId: String,
        callback: OnDataLoadedCallback<Boolean>
    ) {
        LocalAsyncTask<String, Boolean>(callback) {
            examDetailsDao.deleteExamDetail(examDetailId)
        }.execute(examDetailId)
    }

    companion object {
        private var instance: ExamDetailsLocalDataSource? = null
        fun getInstance(examDetailDao: ExamDetailsDAO): ExamDetailsLocalDataSource =
            instance ?: ExamDetailsLocalDataSource(examDetailDao).also {
                instance = it
            }
    }
}
