package com.sunasterisk.englishflashcard.data.source.local.dao

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.sunasterisk.englishflashcard.data.model.Dictionary
import com.sunasterisk.englishflashcard.database.SQLiteHelper
import com.sunasterisk.englishflashcard.database.SQLiteTable

class DictionaryDAOlmpl private constructor(context: Context) : DictionaryDAO {

    private val writableDatabase: SQLiteDatabase =
        SQLiteHelper.getInstance(context).writableDatabase
    private val readableDatabase: SQLiteDatabase =
        SQLiteHelper.getInstance(context).readableDatabase

    @SuppressLint("Recycle")
    override fun getAllDictionaries(TopicId: String): List<Dictionary> {
        val dictionaries = mutableListOf<Dictionary>()
        val cursor: Cursor = readableDatabase.query(
            SQLiteTable.TABLE_DICTIONARY,
            null,
            SQLiteTable.COL_ID_TOPICS + " = ?",
            arrayOf(TopicId),
            null,
            null,
            null
        ).apply {
            moveToFirst()
        }
        while (!cursor.isAfterLast) {
            dictionaries.add(Dictionary(cursor))
            cursor.moveToNext()
        }
        return dictionaries
    }

    override fun addDictionary(dictionary: Dictionary): Boolean {
        return writableDatabase.insert(
            SQLiteTable.TABLE_DICTIONARY,
            null,
            dictionary.getContentValues()
        ) > 0
    }

    override fun deleteDictionary(dictionaryId: String): Boolean {
        return writableDatabase.delete(
            SQLiteTable.TABLE_DICTIONARY,
            SQLiteTable.COL_ID_DICTIONARY + " = ?",
            arrayOf(dictionaryId)
        ) > 0
    }

    override fun searchDictionaies(nameEnglish: String): List<Dictionary> {
        val dictionaries = mutableListOf<Dictionary>()
        val cursor: Cursor = readableDatabase.query(
            SQLiteTable.TABLE_DICTIONARY,
            null,
            SQLiteTable.COL_WORD + " LIKE ?",
            arrayOf("$nameEnglish%"),
            null,
            null,
            null
        ).apply {
            moveToFirst()
        }
        while (!cursor.isAfterLast) {
            dictionaries.add(Dictionary(cursor))
            cursor.moveToNext()
        }
        return dictionaries
    }

    companion object {
        private var instance: DictionaryDAOlmpl? = null
        fun getInstance(context: Context) =
            instance ?: DictionaryDAOlmpl(context).also { instance = it }
    }
}
