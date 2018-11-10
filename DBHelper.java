package com.assignment.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by SOIS on 11/9/2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;

    static final String TABLE_NAME = "users";
    static final String DETAILS_TABLE = "user_details";

    static final String NAME = "name";
    static final String name1 = "Name";
    static final String EMAIL = "email";
    static final String PASSWORD = "password";
    static final String MOBILE = "mobile";
    static final String ID = "id";


    static final String SEX = "sex";
    static final String HEIGHT = "height";
    static final String WEIGHT = "weight";
    static final String BLOOD_GROUP = "blood_group";
    static final String AGE = "age";
    private static final String DB_NAME = "myapp";


    DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(name text , email text , password text , mobile integer , id integer )");
        db.execSQL("create table " + DETAILS_TABLE + "(Name text, sex integer , height integer , weight integer , blood_group text , age integer)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DETAILS_TABLE);
        onCreate(db);

    }

    public boolean insert1(String name, String email, String password, int mobile, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME, name);
        contentValues.put(EMAIL, email);
        contentValues.put(PASSWORD,password);
        contentValues.put(MOBILE,mobile);
        contentValues.put(ID, id);
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
        return true;

    }

    public boolean insertUserDetails(String Name, String sex, String weight, String height, String blood_group,String age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(name1,Name);
        contentValues.put(SEX, sex);
        contentValues.put(HEIGHT,height);
        contentValues.put(WEIGHT,weight);
        contentValues.put(BLOOD_GROUP,blood_group);
        contentValues.put(AGE,age);
        db.insert(DETAILS_TABLE, null, contentValues);
        db.close();
        return true;

    }

    public boolean validate(String email, String password) {
        Log.v("validate", email);
        Log.v("validate", password);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cs = db.rawQuery("select * from users where email=? and password=?", new String[]{email, password});
        if (cs.getCount() > 0)
            return true;
        else
            return false;

    }

    public String fetchByID(String Name) {
        String sql = "SELECT " + SEX + " FROM " + DETAILS_TABLE + " WHERE " + name1 + "='" + Name + "' LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String Gender = cursor.getString(cursor.getColumnIndex("sex"));
            cursor.close();
            return Gender;
        } else {
            cursor.close();
            return null;
        }
    }






    public String fetchByID1(String Name) {
        String sql = "SELECT " + HEIGHT + " FROM " + DETAILS_TABLE + " WHERE " + name1 + "='" + Name + "' LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String Gender = cursor.getString(cursor.getColumnIndex("height"));
            cursor.close();
            return Gender;
        } else {
            cursor.close();
            return null;
        }
    }

    public String fetchByID2(String Name) {
        String sql = "SELECT " + WEIGHT+ " FROM " + DETAILS_TABLE + " WHERE " + name1 + "='" + Name + "' LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String Gender = cursor.getString(cursor.getColumnIndex("weight"));
            cursor.close();
            return Gender;
        } else {
            cursor.close();
            return null;
        }
    }

    public String fetchByID5(String Name) {
        String sql = "SELECT " + BLOOD_GROUP+ " FROM " + DETAILS_TABLE + " WHERE " + name1 + "='" + Name + "' LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String Gender = cursor.getString(cursor.getColumnIndex("blood_group"));
            cursor.close();
            return Gender;
        } else {
            cursor.close();
            return null;
        }
    }

    public String fetchByID3(String Name) {
        String sql = "SELECT " + AGE + " FROM " + DETAILS_TABLE + " WHERE " + name1 + "='" + Name + "' LIMIT 1";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            String Gender = cursor.getString(cursor.getColumnIndex("age"));
            cursor.close();
            return Gender;
        } else {
            cursor.close();
            return null;
        }
    }





}

