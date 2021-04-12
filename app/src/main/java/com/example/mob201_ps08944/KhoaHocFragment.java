package com.example.mob201_ps08944;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.mob201_ps08944.adapter.KhoaHocAdapter;
import com.example.mob201_ps08944.model.KhoaHoc;
import com.example.mob201_ps08944.sql.KhoaHocDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class KhoaHocFragment extends Fragment {

    public KhoaHocAdapter adapter;
    FloatingActionButton btnSP;
    Button btnXoa;
    ListView lvKH;
    ArrayList<KhoaHoc> khoaHocs;
    KhoaHocDAO dao;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_khoa_hoc, container, false);

        btnSP = view.findViewById(R.id.floatbtnSP);
        lvKH = view.findViewById(R.id.lv_KH);
        btnXoa=view.findViewById(R.id.btnXoa);

        btnSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),KHActivity.class);
                startActivity(intent);
            }
        });


        dao = new KhoaHocDAO(getContext());

        return view;
    }



    @Override
    public void onResume() {
        super.onResume();

        capnhatLV();
    }
//
//    public static void  xoaKH(String maKH){
//
//        dao.delete(maKH);
//
//        capnhatLV();
//
//    }

    public void capnhatLV(){
        // lay data tu sqlite

       khoaHocs = (ArrayList<KhoaHoc>) dao.getKhoaHocAll();

        // gan adapter

        adapter = new KhoaHocAdapter(getContext(), khoaHocs);

        // dua len listView

        lvKH.setAdapter(adapter);
    }

}
