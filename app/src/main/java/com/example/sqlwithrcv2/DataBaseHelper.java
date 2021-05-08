package com.example.sqlwithrcv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {


    static final String DATABASEnAME = "ghb";
    static final int DATABASEvERSION = 1;
    static final String TABLEnAME = "student";

    static final String COL_ID =  "id";
    static final String COL_NAME =  "name";
    static final String COL_PHONE =  "phone";
    static final String COL_EMAIL =  "email";

    static  final String CREATEtABLE =  "create table "+ TABLEnAME +" ( " +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COL_NAME + " TEXT, "+
             COL_PHONE + " TEXT, "+
            COL_EMAIL + " TEXT"+
            ");";


    public DataBaseHelper(@Nullable Context context) {
        super(context,DATABASEnAME,null, DATABASEvERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATEtABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ TABLEnAME);
        onCreate(db);
    }
}
