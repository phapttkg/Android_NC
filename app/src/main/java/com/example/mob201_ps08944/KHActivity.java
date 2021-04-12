package com.example.mob201_ps08944;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mob201_ps08944.model.KhoaHoc;
import com.example.mob201_ps08944.sql.KhoaHocDAO;

public class KHActivity extends AppCompatActivity {
    EditText edtMaKH, edtTenKH, edtThoigianBD, edtThoigianKT, edtMota;
    Button btnThem, btnSua;
    KhoaHoc khoaHoc;
    KhoaHocDAO khoaHocDAO;
    String tenkh,makh,sgbd,tgkt,mota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kh);


        //anh xa
        edtMaKH = findViewById(R.id.edtMaKH);
        edtTenKH = findViewById(R.id.edtTenKH);
        edtThoigianBD = findViewById(R.id.edtThoigianBD);
        edtThoigianKT = findViewById(R.id.edtThoigianKT);
        edtMota = findViewById(R.id.edtMota);

        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);

        // lay data tu bundle
//
//        Intent intent = getIntent();
//        Bundle bundle = intent.getBundleExtra("suaKH");
//        String maKH1 = bundle.getString("maKH", "");
//        String tenKH1 = bundle.getString("tenKH", "");
//        String thoigianBD1 = bundle.getString("thoigianBD", "");
//        String thoigianKT1 = bundle.getString("thoigianKT", "");
//        String mota1 = bundle.getString("mota", "");

//        makh=getIntent().getStringExtra("maKH");
//        tenkh=getIntent().getStringExtra("tenKH");
//        sgbd=getIntent().getStringExtra("thoigianBD");
//        tgkt=getIntent().getStringExtra("thoigianKT");
//        mota=getIntent().getStringExtra("mota");
//
//        edtTenKH.setText(tenkh);
//        edtTenKH.setText(sgbd);
//        edtTenKH.setText(tgkt);
//        edtTenKH.setText(mota);

        String maKH = edtMaKH.getText().toString();
        String tenKH = edtTenKH.getText().toString();
        String thoigianBD = edtThoigianBD.getText().toString();
        String thoigianKT = edtThoigianKT.getText().toString();
        String mota = edtMota.getText().toString();

        //dua data len EditText
        edtMaKH.setText(maKH);
        edtTenKH.setText(tenKH);
        edtThoigianBD.setText(thoigianBD);
        edtThoigianKT.setText(thoigianKT);
        edtMota.setText(mota);

        // khoa EditText MaSach

        if (!maKH.isEmpty()) {
            edtMaKH.setEnabled(false);
        }

        // them data vao SQLite

        khoaHocDAO = new KhoaHocDAO(this);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String maKH = edtMaKH.getText().toString();
                String tenKH = edtTenKH.getText().toString();
                String thoigianBD = edtThoigianBD.getText().toString();
                String thoigianKT = edtThoigianKT.getText().toString();
                String mota = edtMota.getText().toString();

                khoaHoc = new KhoaHoc(maKH, tenKH, thoigianBD,thoigianKT,mota);

                long kq = khoaHocDAO.insert(khoaHoc);

                if (kq == -1) {
                    Toast.makeText(KHActivity.this, "insert that bai", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(KHActivity.this, "insert thanh cong", Toast.LENGTH_SHORT).show();
                    // ket thuc activity
                    finish();
                }

            }
        });

        // Sua data

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maKH1 = edtMaKH.getText().toString();
                String tenKH1 = edtTenKH.getText().toString();
                String thoigianBD1 = edtThoigianBD.getText().toString();
                String thoigianKT1 = edtThoigianKT.getText().toString();
                String mota1 = edtMota.getText().toString();

                khoaHoc = new KhoaHoc(maKH1, tenKH1, thoigianBD1,thoigianKT1,mota1);

                long kq = khoaHocDAO.update(khoaHoc);

                if (kq == -1) {
                    Toast.makeText(KHActivity.this, "update that bai", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(KHActivity.this, "update thanh cong", Toast.LENGTH_SHORT).show();
                    // ket thuc activity
                    finish();
                }

            }
        });

    }

}

