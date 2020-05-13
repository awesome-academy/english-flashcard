package com.sunasterisk.englishflashcard.data.model

import android.content.ContentValues
import android.database.Cursor
import com.sunasterisk.englishflashcard.database.SQLiteTable

data class Topics(
    val id: Int,
    val nameTopics: String,
    val imgTopics: String
) {
    constructor(cursor: Cursor) : this(
        id = cursor.getInt(cursor.getColumnIndex(SQLiteTable.COL_ID_TOPICS)),
        nameTopics = cursor.getString(cursor.getColumnIndex(SQLiteTable.COL_NAME_TOPICS)),
        imgTopics = cursor.getString(cursor.getColumnIndex(SQLiteTable.COL_IMG_TOPICS))
    )

    fun getContentValues() = ContentValues().apply {
        put(SQLiteTable.COL_NAME_TOPICS, nameTopics)
        put(SQLiteTable.COL_IMG_TOPICS, imgTopics)
    }
}
