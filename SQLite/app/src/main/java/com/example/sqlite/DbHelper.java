package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Userdetails(name TEXT PRIMARY KEY,contact TEXT,dob TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists Userdetails");
    }

    public Boolean insertUserData(String name, String contact, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        long res = db.insert("Userdetails", null, contentValues);
        if (res == -1) {
            return false;
        } else
            return true;
    }

    public Boolean updateUserData(String name, String contact, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        Cursor cursor = db.rawQuery("SELECT * FROM Userdetails WHERE name=?", new String[]{name});
        if (cursor.getCount() > 0) {
            long res = db.update("Userdetails", contentValues, "name=?", new String[]{name});
            if (res == -1) {
                return false;
            } else
                return true;
        } else
            return false;
    }

    public Boolean deleteUserData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Userdetails WHERE name=?", new String[]{name});
        if (cursor.getCount() > 0) {
            long res = db.delete("Userdetails", "name=?", new String[]{name});
            if (res == -1) {
                return false;
            } else
                return true;
        } else
            return false;
    }

    public Cursor getUserData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Userdetails", null);
        return cursor;
    }
}
