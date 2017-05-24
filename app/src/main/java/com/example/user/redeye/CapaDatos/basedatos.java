package com.example.user.redeye.CapaDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class basedatos extends SQLiteOpenHelper {

    String tabla= "CREATE TABLE Codigos(ID INTEGER PRIMARY KEY ,CODIGO TEXT)";
    public basedatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table tabla");
        db.execSQL(tabla);
    }
}
