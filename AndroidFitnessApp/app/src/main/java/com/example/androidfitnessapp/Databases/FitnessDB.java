package com.example.androidfitnessapp.Databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class FitnessDB extends SQLiteAssetHelper {


    private static final String DB_NAME = "Fitness.db";
    private static final int DB_VER=1;

    public FitnessDB(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

     public int getSettingMode()
     {
         SQLiteDatabase db = getReadableDatabase();
         SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

         String[] sqlSelect = {"Mode"};
         String sqlTable = "Setting";

         qb.setTables (sqlTable);
         Cursor c = qb.query(db, sqlSelect, null,null,null,null,null) ;
         c.moveToFirst();
         return c.getInt(c.getColumnIndex("Mode"));
     }

     public void saveSettingMode(int value)

     {
         SQLiteDatabase db = getReadableDatabase();
         String query = "UPDATE Setting SET Mode = " + value;
         db.execSQL(query);
     }

}
