package com.example.projektarbeit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ActivityLogDbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="activity.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_USERLOG="userlog";
    //Spalten der Tabelle
    //ID
    public static final String COLUMN_ID="id";
    //Überschrift

    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_PASSWORT="passwort";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_ALTER="alter";

    public ActivityLogDbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static final String SQL_CREATE=
            "create table "+ TABLE_USERLOG + "(" +
                    COLUMN_ID + " integer primary key autoincrement, " +
                    COLUMN_EMAIL + " text not null, " +
                    COLUMN_PASSWORT + " text not null, " +
                    COLUMN_NAME + " text not null, " +
                    COLUMN_ALTER + " integer); ";



    @Override
    public void onCreate(SQLiteDatabase db)
    {
        sqLiteDataBase.execSQL(SQL_CREATE); //Warum geht das nicht?
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
