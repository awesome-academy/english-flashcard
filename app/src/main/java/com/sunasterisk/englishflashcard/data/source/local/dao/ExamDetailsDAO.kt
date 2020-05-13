package com.sunasterisk.englishflashcard.data.source.local.dao

import com.sunasterisk.englishflashcard.data.model.ExamDetails

interface ExamDetailsDAO {
    fun getAllExamDetails(examId: String): List<ExamDetails>
    fun addExamDetail(examDetail: ExamDetails): Boolean
    fun deleteExamDetail(examDetailsId: String): Boolean
}
