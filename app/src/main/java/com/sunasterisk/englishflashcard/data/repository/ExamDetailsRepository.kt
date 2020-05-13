package com.sunasterisk.englishflashcard.data.repository

import com.sunasterisk.englishflashcard.data.model.ExamDetails
import com.sunasterisk.englishflashcard.data.source.ExamDetailsDataSource
import com.sunasterisk.englishflashcard.data.source.OnDataLoadedCallback

class ExamDetailsRepository(private val localDataSource: ExamDetailsDataSource.Local) :
    ExamDetailsDataSource.Local {

    override fun getAllExamDetails(
        examId: String,
        callback: OnDataLoadedCallback<List<ExamDetails>>
    ) {
        localDataSource.getAllExamDetails(examId, callback)
    }

    override fun addExamDetail(examDetail: ExamDetails, callback: OnDataLoadedCallback<Boolean>) {
        localDataSource.addExamDetail(examDetail, callback)
    }

    override fun deleteExamDetail(
        examDetailId: String,
        callback: OnDataLoadedCallback<Boolean>
    ) {
        localDataSource.deleteExamDetail(examDetailId, callback)
    }

    companion object {
        private var instance: ExamDetailsRepository? = null
        fun getInstance(local: ExamDetailsDataSource.Local) =
            instance ?: ExamDetailsRepository(local).also { instance = it }
    }
}
