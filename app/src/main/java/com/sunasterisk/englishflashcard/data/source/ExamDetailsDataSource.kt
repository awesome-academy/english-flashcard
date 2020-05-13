package com.sunasterisk.englishflashcard.data.source

import com.sunasterisk.englishflashcard.data.model.ExamDetails

interface ExamDetailsDataSource {
    interface Local {
        fun getAllExamDetails(examId: String, callback: OnDataLoadedCallback<List<ExamDetails>>)
        fun addExamDetail(examDetail: ExamDetails, callback: OnDataLoadedCallback<Boolean>)
        fun deleteExamDetail(examDetailId: String, callback: OnDataLoadedCallback<Boolean>)
    }
}
