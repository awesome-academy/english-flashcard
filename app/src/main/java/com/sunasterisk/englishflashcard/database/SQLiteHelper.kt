package com.sunasterisk.englishflashcard.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context) : SQLiteOpenHelper(
    context, DATABASE_NAME, null,
    DATABASE_VERSION
) {

    companion object {
        var DATABASE_NAME = "db_flashcard_english"
        var DATABASE_VERSION = 1
        private var instance: SQLiteHelper? = null
        fun getInstance(context: Context) =
            instance ?: SQLiteHelper(context).also { instance = it }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.run {
            execSQL(SQLiteTable.CREATE_TABLE_TOPICS)
            db.execSQL(SQLiteTable.CREATE_TABLE_DICTIONARY)
            db.execSQL(SQLiteTable.CREATE_TABLE_WORDENGLISH)
            db.execSQL(SQLiteTable.CREATE_TABLE_WORDVIETNAMESE)
            db.execSQL(SQLiteTable.CREATE_TABLE_EXAM)
            db.execSQL(SQLiteTable.CREATE_TABLE_EXAMDETAILS)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS " + SQLiteTable.CREATE_TABLE_TOPICS)
        db.execSQL("DROP TABLE IF EXISTS " + SQLiteTable.CREATE_TABLE_DICTIONARY)
        db.execSQL("DROP TABLE IF EXISTS " + SQLiteTable.CREATE_TABLE_WORDENGLISH)
        db.execSQL("DROP TABLE IF EXISTS " + SQLiteTable.CREATE_TABLE_WORDVIETNAMESE)
        db.execSQL("DROP TABLE IF EXISTS " + SQLiteTable.CREATE_TABLE_EXAM)
        db.execSQL("DROP TABLE IF EXISTS " + SQLiteTable.CREATE_TABLE_EXAMDETAILS)
        onCreate(db)
    }
}
