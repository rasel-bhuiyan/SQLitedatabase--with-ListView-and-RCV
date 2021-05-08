package com.example.sqlwithrcv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DBsource {
    DataBaseHelper dataBaseHelper;
    SQLiteDatabase sqLiteDatabase;



    public DBsource( Context context) {
        dataBaseHelper = new DataBaseHelper(context);
    }
    public  void Open(){
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();
    }
    public  void Close(){
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();
    }

    boolean AddInfo(ModelClass modelClass){
        this.Open();

        ContentValues contentValues = new ContentValues();
        contentValues.put(dataBaseHelper.COL_NAME,modelClass.Name);
        contentValues.put(dataBaseHelper.COL_PHONE,modelClass.Number);
        contentValues.put(dataBaseHelper.COL_EMAIL,modelClass.Email);

        Long insert = sqLiteDatabase.insert(DataBaseHelper.TABLEnAME,null,contentValues);

        if(insert > 0){
            return true;
        }else
            return false;
    }

    public ArrayList<ModelClass> showDATA (){
        this.Open();

        ArrayList<ModelClass> arrayList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(dataBaseHelper.TABLEnAME,null,null,null,null,null,null);

        if(cursor.moveToFirst()){

            do {

                String name = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_NAME));
                String phone =  cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_PHONE));
                String email =  cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_EMAIL));

                ModelClass modelClass = new ModelClass(name,phone,email);
                arrayList.add(modelClass);

            }while (cursor.moveToNext());

        }

        this.Close();
        cursor.close();

        return arrayList;
    }









}
