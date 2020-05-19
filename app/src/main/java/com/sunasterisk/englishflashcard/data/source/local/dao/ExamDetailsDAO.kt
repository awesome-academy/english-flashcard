package com.sunasterisk.englishflashcard.data.source.local.dao

import com.sunasterisk.englishflashcard.data.model.ExamDetail

interface ExamDetailsDAO {
    fun getAllExamDetails(examId: String): List<ExamDetail>
    fun addExamDetail(examDetail: ExamDetail): Boolean
    fun deleteExamDetail(examDetailsId: String): Boolean
}
