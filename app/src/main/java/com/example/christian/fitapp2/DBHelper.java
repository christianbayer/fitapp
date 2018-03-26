package com.example.christian.fitapp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DBContract.Circuit.CREATE_TABLE);
        sqLiteDatabase.execSQL(DBContract.Route.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DBContract.Circuit.DELETE_TABLE);
        sqLiteDatabase.execSQL(DBContract.Route.DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }
}
