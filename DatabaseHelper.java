package com.tharushi.lifetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_TO_DO_LIST = "item.db";
    public static final String TABLE_TO_DO_LIST = "item_table";
    public static final String COL_1 = "item";

    public DatabaseHelper( Context context) {
        super(context,DATABASE_TO_DO_LIST, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TO_DO = "CREATE TABLE " + TABLE_TO_DO_LIST + "(item INT" + "PRIMARYKEY)";
        db.execSQL(CREATE_TO_DO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE " + TABLE_TO_DO_LIST );
        onCreate(db);
    }

    public boolean insertData (String item){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,item);
        long results = sqLiteDatabase.insert(TABLE_TO_DO_LIST, null,contentValues);
        if (results == -1){
            return false;
        }else {
            return true;
        }
    }
    public Cursor getalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor results =   db.rawQuery( " select * from " + TABLE_TO_DO_LIST, null);
        return results;
    }
    public  boolean updateData ( String item){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, item);
        sqLiteDatabase.update(TABLE_TO_DO_LIST, contentValues,"number =?", new String[]{item});
        return true;
    }

    public Integer delete (String item){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_TO_DO_LIST, "number = ?", new String[] {item});
    }
}
