package com.sunasterisk.englishflashcard.data.source.local.dao

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.sunasterisk.englishflashcard.data.model.ExamDetails
import com.sunasterisk.englishflashcard.database.SQLiteHelper
import com.sunasterisk.englishflashcard.database.SQLiteTable

class ExamDetailsDAOlmpl private constructor(context: Context) : ExamDetailsDAO {

    private val writableDatabase: SQLiteDatabase =
        SQLiteHelper.getInstance(context).writableDatabase
    private val readableDatabase: SQLiteDatabase =
        SQLiteHelper.getInstance(context).readableDatabase

    @SuppressLint("Recycle")
    override fun getAllExamDetails(examId: String): List<ExamDetails> {
        val listExamDetails = mutableListOf<ExamDetails>()
        val query = "SELECT * FROM " + SQLiteTable.TABLE_EXAMDETAILS
        val cursor: Cursor = readableDatabase.query(
            SQLiteTable.TABLE_EXAMDETAILS,
            null,
            SQLiteTable.COL_ID_EXAM + " = ?",
            arrayOf(examId),
            null,
            null,
            null
        ).apply {
            moveToFirst()
        }
        while (!cursor.isAfterLast) {
            listExamDetails.add(ExamDetails(cursor))
            cursor.moveToNext()
        }
        return listExamDetails
    }

    override fun addExamDetail(examDetail: ExamDetails): Boolean {
        return writableDatabase.insert(
            SQLiteTable.TABLE_EXAMDETAILS,
            null,
            examDetail.getContentValues()
        ) > 0
    }

    override fun deleteExamDetail(examDetailsId: String): Boolean {
        return writableDatabase.delete(
            SQLiteTable.TABLE_EXAMDETAILS,
            SQLiteTable.COL_ID_EXAMDETAILS + " = ?",
            arrayOf(examDetailsId)
        ) > 0
    }

    companion object {
        private var instance: ExamDetailsDAOlmpl? = null
        fun getInstance(context: Context) =
            instance ?: ExamDetailsDAOlmpl(context).also { instance = it }
    }
}
