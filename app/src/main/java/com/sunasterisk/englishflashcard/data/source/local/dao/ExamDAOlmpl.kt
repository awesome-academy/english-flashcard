package com.sunasterisk.englishflashcard.data.source.local.dao

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.sunasterisk.englishflashcard.data.model.Exam
import com.sunasterisk.englishflashcard.database.SQLiteHelper
import com.sunasterisk.englishflashcard.database.SQLiteTable

class ExamDAOlmpl private constructor(context: Context) : ExamDAO {

    private val writableDatabase: SQLiteDatabase =
        SQLiteHelper.getInstance(context).writableDatabase
    private val readableDatabase: SQLiteDatabase =
        SQLiteHelper.getInstance(context).readableDatabase

    @SuppressLint("Recycle")
    override fun getAllExames(): List<Exam> {
        val listExam = mutableListOf<Exam>()
        val cursor: Cursor =
            readableDatabase.query(SQLiteTable.TABLE_EXAM, null, null, null, null, null, null)
                .apply {
                    moveToFirst()
                }
        while (!cursor.isAfterLast) {
            listExam.add(Exam(cursor))
            cursor.moveToNext()
        }
        return listExam
    }

    override fun addExam(exam: Exam): Boolean {
        return writableDatabase.insert(SQLiteTable.TABLE_EXAM, null, exam.getContentValues()) > 0
    }

    override fun deleteExam(examId: String): Boolean {
        return writableDatabase.delete(
            SQLiteTable.TABLE_EXAM,
            SQLiteTable.COL_ID_EXAM + " = ?",
            arrayOf(examId)
        ) > 0
    }

    companion object {
        private var instance: ExamDAOlmpl? = null
        fun getInstance(context: Context) =
            instance ?: ExamDAOlmpl(context).also { instance = it }
    }
}
