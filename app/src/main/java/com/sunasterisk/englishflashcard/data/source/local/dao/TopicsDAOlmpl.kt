package com.sunasterisk.englishflashcard.data.source.local.dao

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.sunasterisk.englishflashcard.data.model.Topic
import com.sunasterisk.englishflashcard.database.SQLiteHelper
import com.sunasterisk.englishflashcard.database.SQLiteTable

class TopicsDAOlmpl private constructor(context: Context) : TopicsDAO {

    private val writableDatabase: SQLiteDatabase =
        SQLiteHelper.getInstance(context).writableDatabase
    private val readableDatabase: SQLiteDatabase =
        SQLiteHelper.getInstance(context).readableDatabase

    @SuppressLint("Recycle")
    override fun getAllTopics(): List<Topic> {
        val listTopics = mutableListOf<Topic>()
        val cursor: Cursor =
            readableDatabase.query(SQLiteTable.TABLE_TOPICS, null, null, null, null, null, null)
                .apply {
                    moveToFirst()
                }
        while (!cursor.isAfterLast) {
            listTopics.add(Topic(cursor))
            cursor.moveToNext()
        }
        return listTopics
    }

    override fun addTopic(topic: Topic): Boolean {
        return writableDatabase.insert(SQLiteTable.TABLE_TOPICS, null, topic.getContentValues()) > 0
    }

    override fun deleteTopic(topicId: String): Boolean {
        return writableDatabase.delete(
            SQLiteTable.TABLE_TOPICS,
            SQLiteTable.COL_ID_TOPICS + " = ?",
            arrayOf(topicId)
        ) > 0
    }

    companion object {
        private var instance: TopicsDAOlmpl? = null
        fun getInstance(context: Context) =
            instance ?: TopicsDAOlmpl(context).also { instance = it }
    }
}
