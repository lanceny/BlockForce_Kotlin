package com.example.blockforce_kotlin

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ScoreDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DBNAME, null, VERSION) {
    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE score (" + "Lines INTEGER PRIMARY KEY, date TEXT,Latest INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

    companion object {
        private val DBNAME: String = "score.sqlite"
        private const val VERSION = 1
    }
}