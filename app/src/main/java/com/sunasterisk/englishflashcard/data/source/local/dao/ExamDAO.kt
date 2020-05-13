package com.sunasterisk.englishflashcard.data.source.local.dao

import com.sunasterisk.englishflashcard.data.model.Exam

interface ExamDAO {
    fun getAllExames(): List<Exam>
    fun addExam(exam: Exam): Boolean
    fun deleteExam(examId: String): Boolean
}
