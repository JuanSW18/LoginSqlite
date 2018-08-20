package com.example.juan.loginsqlite.Datos;

import android.provider.BaseColumns;

public final class UsersContract {

    public static abstract class UserEntry implements BaseColumns{
        public static final String TABLE_NAME = "users";

        public static final String USER = "user";
        public static final String PASSWORD = "pass";

        public static final String SQL_CREATE_USER_TABLE =
                "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
                        UserEntry._ID + " INTEGER PRIMARY KEY," +
                        UserEntry.USER + " TEXT," +
                        UserEntry.PASSWORD + " TEXT)";

        public static final String SQL_DELETE_USER_TABLE =
                "DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME;
    }

}
