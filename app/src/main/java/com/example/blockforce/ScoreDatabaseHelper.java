package com.example.blockforce;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ScoreDatabaseHelper extends SQLiteOpenHelper {
    static final private String DBNAME = "score.sqlite";
    static final private int VERSION = 1;
    public ScoreDatabaseHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE score (" + "Lines INTEGER PRIMARY KEY, date TEXT,Latest INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}