package com.sunasterisk.englishflashcard.data.model

import android.content.ContentValues
import android.database.Cursor
import com.sunasterisk.englishflashcard.database.SQLiteTable

data class Dictionary(
    var id: Int = 0,
    var word: String = "",
    var wordType: String = "",
    var spelling: String = "",
    var translate: String = "",
    var topicsId: Int = 0
) {
    constructor(cursor: Cursor) : this(
        id = cursor.getInt(cursor.getColumnIndex(SQLiteTable.COL_ID_DICTIONARY)),
        word = cursor.getString(cursor.getColumnIndex(SQLiteTable.COL_WORD)),
        wordType = cursor.getString(cursor.getColumnIndex(SQLiteTable.COL_WORD_TYPE)),
        spelling = cursor.getString(cursor.getColumnIndex(SQLiteTable.COL_SPELLING)),
        translate = cursor.getString(cursor.getColumnIndex(SQLiteTable.COL_TRANSLATE)),
        topicsId = cursor.getInt(cursor.getColumnIndex(SQLiteTable.COL_ID_TOPICS))
    )

    fun getContentValues() = ContentValues().apply {
        put(SQLiteTable.COL_WORD, word)
        put(SQLiteTable.COL_WORD_TYPE, wordType)
        put(SQLiteTable.COL_SPELLING, spelling)
        put(SQLiteTable.COL_TRANSLATE, translate)
        put(SQLiteTable.COL_ID_TOPICS, topicsId)
    }
}
