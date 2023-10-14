package com.example.dianasari.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class Helper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "crud";

    public Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TABLE = "CREATE TABLE jabatanPegawai (id INTEGER PRIMARY KEY autoincrement, name TEXT NOT NULL, jabatan TEXT NOT NULL, alamat TEXT NOT NULL)";
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS jabatanPegawai");
        onCreate(sqLiteDatabase);
    }

    public ArrayList<HashMap<String, String>> getAll() {
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        String QUERY = "SELECT * FROM jabatanPegawai";
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(QUERY, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put("name", cursor.getString(1));
                map.put("jabatan", cursor.getString(2));
                map.put("alamat", cursor.getString(3));
                list.add(map);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public void insert(String name, String jabatan, String alamat) {
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "INSERT INTO jabatanPegawai (name, jabatan, alamat) VALUES('"+name+"','"+jabatan+"','"+alamat+"')";
        database.execSQL(QUERY);
    }

    public void update(int id, String name, String jabatan, String alamat) {
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "UPDATE jabatanPegawai SET name = '"+name+"', jabatan = '"+jabatan+"', alamat = '"+alamat+"' WHERE id = "+id;
        database.execSQL(QUERY);
    }

    public void delete(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "DELETE FROM jabatanPegawai WHERE id = " +id;
        database.execSQL(QUERY);
    }
}
