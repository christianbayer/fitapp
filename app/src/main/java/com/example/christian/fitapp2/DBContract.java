package com.example.christian.fitapp2;

import android.net.Uri;
import android.provider.BaseColumns;

public final class DBContract {
    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "fitapp.db";

    public static final String CONTENT_AUTHORITY = "com.example.christian.fitapp2";

    private DBContract() {
    }

    public static abstract class Circuit {
        public static final String TABLE_NAME = "circuit";
        public static final String COL_ID = "id";
        public static final String COL_NAME = "name";
        public static final String COL_DESCRIPTION = "description";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY," +
                COL_NAME + " TEXT," +
                COL_DESCRIPTION + " TEXT)";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static abstract class Route {
        public static final String TABLE_CIRCUIT_NAME = "circuit";
        public static final String TABLE_CIRCUIT_PK = "id";
        public static final String TABLE_NAME = "route";
        public static final String COL_ID = "id";
        public static final String COL_CIRCUIT_ID = "circuit_id";
        public static final String COL_LATITUDE = "latitude";
        public static final String COL_LONGITUDE = "longitude";
        public static final String COL_ALTITUDE = "altitude";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY," +
                COL_CIRCUIT_ID + " INTEGER," +
                COL_LATITUDE + " NUMERIC," +
                COL_LONGITUDE + " NUMERIC," +
                COL_ALTITUDE + " NUMERIC," +
                " FOREIGN KEY (" + COL_CIRCUIT_ID + ") REFERENCES " + TABLE_CIRCUIT_NAME + "(" + TABLE_CIRCUIT_PK + "));";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static final Uri CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
}
