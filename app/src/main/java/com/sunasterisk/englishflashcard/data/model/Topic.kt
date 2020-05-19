package com.sunasterisk.englishflashcard.data.model

import android.content.ContentValues
import android.database.Cursor
import com.sunasterisk.englishflashcard.database.SQLiteTable

data class Topic(
    val id: Int,
    val name: String,
    val image: String
) {
    constructor(cursor: Cursor) : this(
        id = cursor.getInt(cursor.getColumnIndex(SQLiteTable.COL_ID_TOPICS)),
        name = cursor.getString(cursor.getColumnIndex(SQLiteTable.COL_NAME_TOPICS)),
        image = cursor.getString(cursor.getColumnIndex(SQLiteTable.COL_IMG_TOPICS))
    )

    fun getContentValues() = ContentValues().apply {
        put(SQLiteTable.COL_NAME_TOPICS, name)
        put(SQLiteTable.COL_IMG_TOPICS, image)
    }
}
