package com.sunasterisk.englishflashcard.data.model

import android.content.ContentValues
import android.database.Cursor
import com.sunasterisk.englishflashcard.database.SQLiteTable

data class ExamDetails(
    val id: Int,
    val question: String,
    val answerA: String,
    val answerB: String,
    val answerC: String,
    val answerD: String,
    val check: Int,
    val examId: Int
) {
    constructor(cursor: Cursor) : this(
        id = cursor.getInt(cursor.getColumnIndex(SQLiteTable.COL_ID_EXAMDETAILS)),
        question = cursor.getString(cursor.getColumnIndex(SQLiteTable.COL_QUESTION)),
        answerA = cursor.getString(cursor.getColumnIndex(SQLiteTable.COL_ANSWER_A)),
        answerB = cursor.getString(cursor.getColumnIndex(SQLiteTable.COL_ANSWER_B)),
        answerC = cursor.getString(cursor.getColumnIndex(SQLiteTable.COL_ANSWER_C)),
        answerD = cursor.getString(cursor.getColumnIndex(SQLiteTable.COL_ANSWER_D)),
        check = cursor.getInt(cursor.getColumnIndex(SQLiteTable.COL_CHECK)),
        examId = cursor.getInt(cursor.getColumnIndex(SQLiteTable.COL_ID_EXAM))
    )

    fun getContentValues() = ContentValues().apply {
        put(SQLiteTable.COL_QUESTION, question)
        put(SQLiteTable.COL_ANSWER_A, answerA)
        put(SQLiteTable.COL_ANSWER_B, answerB)
        put(SQLiteTable.COL_ANSWER_C, answerC)
        put(SQLiteTable.COL_ANSWER_D, answerD)
        put(SQLiteTable.COL_CHECK, check)
        put(SQLiteTable.COL_ID_EXAM, examId)
    }
}
