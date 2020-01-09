package com.example.projektarbeit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.os.Build.ID;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="userDB";

    //table scores
    private static final String TABLE_USER="user";
    private static final String USER_ID="id";
    private static final String NAME="name";
    private static final String EMAIL="email";
    private static final String PASSWORT="passwort";
    private static final String ALTER="alter";
    //private static final String POINT_ID="point_id";
    //  private static final String ROUTE_ID="route_id";

    public DatabaseHandler(Context c)
    {
        super(c, DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String CREATE_USER_TABLE="create table " + TABLE_USER + "(" +
            USER_ID + " INTEGER PRIMARY KEY, " +
            NAME + " VARCHAR2(30) NOT NULL, " +
            EMAIL + " VARCHAR2(30), " +
            PASSWORT + " VARCHAR2(30) NOT NULL, " +
            ALTER + " INTEGER, " +
         //   POINT_ID + " INTEGER CONSTRAINT FOREIGN KEY, " +
         //   ROUTE_ID + " INTEGER CONSTRAINT FOREIGN KEY" +
            ");";


    }    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_USER);
        onCreate(db);
    }
    public void addUser(User user)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(USER_ID,user.getId());
        values.put(NAME, user.getName());
        values.put(ALTER, user.getAlter());
        values.put(EMAIL,user.getEmail());
        values.put(PASSWORT, user.getPasswort());
        //müssen hier noch die anderen Werte mit null gefüllt werden?

        db.insert(TABLE_USER,null,values);
        db.close();
    }
    public int updateUser(User user)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(USER_ID,user.getId());
        values.put(NAME, user.getName());
        values.put(ALTER, user.getAlter());
        values.put(EMAIL,user.getEmail());
        values.put(PASSWORT, user.getPasswort());
        //müssen hier noch die anderen Werte mit null gefüllt werden?
        return db.update(TABLE_USER, values, USER_ID + "=?", new String[] {String.valueOf(user.getId())});//warum geht das nicht?
    }
    public void deleteUser(User user)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_USER, USER_ID + "=?", new String[] {String.valueOf(user.getId())});
        db.close();
    }


    public User getUser(String name)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.query(TABLE_USER, new String[]{USER_ID,NAME,ALTER,EMAIL,PASSWORT}, NAME + "=?",
                new String[] {name}, null, null, null,null);
        User user=null;
        if(c.moveToFirst())


            user=new User(Integer.parseInt(c.getString(0)), c.getString(1),Integer.parseInt(c.getString(2)),
                    c.getString(3), c.getString(4));
            c.close();
            db.close();
            return(user);


    }


}
