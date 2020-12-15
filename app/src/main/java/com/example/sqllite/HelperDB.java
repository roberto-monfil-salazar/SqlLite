package com.example.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class HelperDB extends SQLiteOpenHelper {

    public HelperDB(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        onCreate(db);
    }

    public long insertRecord(String Pelicula, String image, String Director, String Actor, String Duracion, String Precio, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.C_Pelicula, Pelicula);
        values.put(Constants.C_IMAGE, image);
        values.put(Constants.C_Director, Director);
        values.put(Constants.C_Actor, Actor);
        values.put(Constants.C_Duracion, Duracion);
        values.put(Constants.C_Precio, Precio);
        values.put(Constants.C_DESCRIPTION, description);

        long id = db.insert(Constants.TABLE_NAME, null, values);
        // INSERT INTO PRODUCTS VALUES(...);

        db.close();
        return id;
    }

    public void updateRecord(String id,String Pelicula,  String image, String Director, String Actor, String Duracion, String Precio, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.C_Pelicula, Pelicula);
        values.put(Constants.C_IMAGE, image);
        values.put(Constants.C_Director, Director);
        values.put(Constants.C_Actor, Actor);
        values.put(Constants.C_Duracion, Duracion);
        values.put(Constants.C_Precio, Precio);
        values.put(Constants.C_DESCRIPTION, description);

        db.update(Constants.TABLE_NAME, values, Constants.C_ID + " = ?", new String[] {id});
        // INSERT INTO PRODUCTS VALUES(...);

        db.close();
        // return id;
    }

    public ArrayList<ModelRecord> getAllRecords(String orderBy) {
        ArrayList<ModelRecord> recordArrayList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME + " ORDER BY " + orderBy;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModelRecord modelRecord = new ModelRecord(
                        "" + cursor.getInt(cursor.getColumnIndex(Constants.C_ID)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_Pelicula)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_IMAGE)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_Director)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_Actor)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_Duracion)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_Precio)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_DESCRIPTION))
                );
                recordArrayList.add(modelRecord);
            } while (cursor.moveToNext());
        }

        db.close();
        return recordArrayList;
    }


    public ArrayList<ModelRecord> searchRecords(String query) {
        ArrayList<ModelRecord> recordArrayList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME + " WHERE " + Constants.C_Pelicula + " LIKE '%" + query + "%'";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ModelRecord modelRecord = new ModelRecord(
                        "" + cursor.getInt(cursor.getColumnIndex(Constants.C_ID)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_Pelicula)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_IMAGE)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_Director)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_Actor)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_Duracion)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_Precio)),
                        "" + cursor.getString(cursor.getColumnIndex(Constants.C_DESCRIPTION))
                );
                recordArrayList.add(modelRecord);
            } while (cursor.moveToNext());
        }

        db.close();
        return recordArrayList;
    }

    public int countRecords() {
        String countQuery = "SELECT * FROM " + Constants.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        cursor.close();
        return count;
    }



}
