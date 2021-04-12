package com.example.mob201_ps08944.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
static final String dbName = "QLKH";
static  final  int dbVersion=1;

public DbHelper(Context context){ super(context,dbName,null, dbVersion);};
@Override
    public void onCreate(SQLiteDatabase db) {

    String createTableSqlLogin="create table login(" +
            "user TEXT PRIMARY KEY," +
            "pass TEXT)";
    db.execSQL(createTableSqlLogin);



    String createTableSql=
            "create table khoahoc (" +
                    "maKH TEXT PRIMARY KEY, " +
                    "tenKH TEXT NOT NULL, " +
                    "thoigianBD TEXT," +
                    "thoigianKT TEXT," +
                    "mota TEXT)";
    db.execSQL(createTableSql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
