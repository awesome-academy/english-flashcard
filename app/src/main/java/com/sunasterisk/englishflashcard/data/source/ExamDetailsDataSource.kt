package com.sunasterisk.englishflashcard.data.source

import com.sunasterisk.englishflashcard.data.model.ExamDetail

interface ExamDetailsDataSource {
    interface Local {
        fun getAllExamDetails(examId: String, callback: OnDataLoadedCallback<List<ExamDetail>>)
        fun addExamDetail(examDetail: ExamDetail, callback: OnDataLoadedCallback<Boolean>)
        fun deleteExamDetail(examDetailId: String, callback: OnDataLoadedCallback<Boolean>)
    }
}
