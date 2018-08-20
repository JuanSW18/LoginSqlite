package com.example.juan.loginsqlite.Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Users.db";

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsersContract.UserEntry.SQL_CREATE_USER_TABLE);

        //Crear un usuario
        ContentValues values = new ContentValues();
        values.put(UsersContract.UserEntry.USER, "admin");
        values.put(UsersContract.UserEntry.PASSWORD, "admin");

        // Insertar valores en la base de datos
        long newRowId = db.insert(UsersContract.UserEntry.TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UsersContract.UserEntry.SQL_DELETE_USER_TABLE);
    }

}
