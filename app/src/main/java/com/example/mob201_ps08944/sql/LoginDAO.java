package com.example.mob201_ps08944.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mob201_ps08944.model.Login;

import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
    private SQLiteDatabase db;

    public LoginDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(Login login) {

        ContentValues values = new ContentValues();

        values.put("user",login.user);
        values.put("pass",login.pass);

        return db.insert("login", null, values);
    }

    public int update(Login login) {
        ContentValues values = new ContentValues();
        values.put("user",login.user);
        values.put("pass",login.pass);


        return db.update("login", values, "user=?", new String[]{login.user});
    }

    public int delete(String user) {
        return db.delete(
                "login", "user", new String[]{user});
    }

    //get theo nhieu tham so

    public List<Login> getLogin(String sql, String... selectionArgs) {

        List<Login> list = new ArrayList<Login>();

        Cursor c = db.rawQuery(sql, selectionArgs);

        while (c.moveToNext()) {

            Login login = new Login();
            login.user = c.getString(c.getColumnIndex("user"));
            login.pass = c.getString(c.getColumnIndex("pass"));


            list.add(login);
        }

        return list;
    }

    //get tat ca khoahoc

    public List<Login> getLoginAll() {
        String sql = "SELECT * FROM login";

        return getLogin(sql);
    }


    //get kh theo ma

    public Login getLoginUser(String user) {

        String sql = "SELECT * FROM login WHERE user=?";

        List<Login> list = getLogin(sql, user);

        return list.get(0);
    }
}
