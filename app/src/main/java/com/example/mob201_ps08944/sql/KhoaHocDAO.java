package com.example.mob201_ps08944.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mob201_ps08944.model.KhoaHoc;

import java.util.ArrayList;
import java.util.List;

public class KhoaHocDAO {

    private SQLiteDatabase db;

    public KhoaHocDAO(Context context) {
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long insert(KhoaHoc k) {

        ContentValues values = new ContentValues();
        values.put("maKH", k.maKH);
        values.put("tenKH", k.tenKH);
        values.put("thoigianBD", k.thoigianBD);
        values.put("thoigianKT", k.thoigianKT);
        values.put("mota", k.mota);

        return db.insert("khoahoc", null, values);
    }

    public int update(KhoaHoc k) {
        ContentValues values = new ContentValues();

        values.put("tenKH", k.tenKH);
        values.put("thoigianBD", k.thoigianBD);
        values.put("thoigianKT", k.thoigianKT);
        values.put("mota", k.mota);

        return db.update("khoahoc", values, "maKH=?", new String[]{k.maKH});
    }

    public void delete(KhoaHoc kh) {
         db.delete(
                "khoahoc", "maKH=?", new String[]{kh.maKH});
    }

    //get theo nhieu tham so

    public List<KhoaHoc> getKhoaHoc(String sql, String... selectionArgs) {

        List<KhoaHoc> list = new ArrayList<KhoaHoc>();

        Cursor c = db.rawQuery(sql, selectionArgs);

        while (c.moveToNext()) {

            KhoaHoc k = new KhoaHoc();
            k.maKH= c.getString(c.getColumnIndex("maKH"));
            k.tenKH = c.getString(c.getColumnIndex("tenKH"));
            k.thoigianBD = c.getString(c.getColumnIndex("thoigianBD"));
            k.thoigianKT= c.getString(c.getColumnIndex("thoigianKT"));
            k.mota=c.getString(c.getColumnIndex("mota"));


            list.add(k);
        }

        return list;
    }

    //get tat ca khoahoc

    public List<KhoaHoc> getKhoaHocAll() {
        String sql = "SELECT * FROM khoahoc";

        return getKhoaHoc(sql);
    }


    //get kh theo ma

    public KhoaHoc getKHmaKH(String maKH) {

        String sql = "SELECT * FROM khoahoc WHERE maKH=?";

        List<KhoaHoc> list = getKhoaHoc(sql, maKH);

        return list.get(0);
    }


}
