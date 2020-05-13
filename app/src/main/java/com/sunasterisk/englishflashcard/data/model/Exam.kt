package com.sunasterisk.englishflashcard.data.model

import android.content.ContentValues
import android.database.Cursor
import com.sunasterisk.englishflashcard.database.SQLiteTable

data class Exam(
    val id: Int,
    val date: String,
    val correctSentences: Int,
    val wrongSentences: Int,
    val totalScore: Int
) {
    constructor(cursor: Cursor) : this(
        id = cursor.getInt(cursor.getColumnIndex(SQLiteTable.COL_ID_EXAM)),
        date = cursor.getString(cursor.getColumnIndex(SQLiteTable.COL_DATE_EXAM)),
        correctSentences = cursor.getInt(cursor.getColumnIndex(SQLiteTable.COL_CORRECT_SENTENCES)),
        wrongSentences = cursor.getInt(cursor.getColumnIndex(SQLiteTable.COL_WRONG_SENTENCES)),
        totalScore = cursor.getInt(cursor.getColumnIndex(SQLiteTable.COL_TOTAL_SCORE))
    )

    fun getContentValues() = ContentValues().apply {
        put(SQLiteTable.COL_DATE_EXAM, date)
        put(SQLiteTable.COL_CORRECT_SENTENCES, correctSentences)
        put(SQLiteTable.COL_WRONG_SENTENCES, wrongSentences)
        put(SQLiteTable.COL_TOTAL_SCORE, totalScore)
    }
}
