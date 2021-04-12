package com.example.mob201_ps08944.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.mob201_ps08944.KHActivity;
import com.example.mob201_ps08944.KhoaHocFragment;
import com.example.mob201_ps08944.MainActivity;
import com.example.mob201_ps08944.R;
import com.example.mob201_ps08944.model.KhoaHoc;
import com.example.mob201_ps08944.sql.KhoaHocDAO;

import java.util.ArrayList;
import java.util.List;

public class KhoaHocAdapter  extends ArrayAdapter {

    TextView tvMaKH, tvTenKh, tvBD,tvKT,tvMota;
    Button btnXoa;
    Context context;
    ArrayList<KhoaHoc> khoaHocs;
    KhoaHocDAO khdao;

    public KhoaHocAdapter(Context context,int resource,ArrayList<KhoaHoc> khoaHocs) {
        super(context, 0, khoaHocs);
    }


    public KhoaHocAdapter(@NonNull Context context, ArrayList<KhoaHoc> khoaHocs) {
        super(context, 0,khoaHocs);
        this.context = context;
        this.khoaHocs =khoaHocs ;
        khdao= new KhoaHocDAO(context);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View v = convertView;

        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.item_khoahoc_list, parent, false);
        }

        final KhoaHoc khoaHoc = khoaHocs.get(position);
        if (khoaHoc != null) {
            tvMaKH=v.findViewById(R.id.tvMaKH);
            tvTenKh=v.findViewById(R.id.tvTenKH);
            tvBD=v.findViewById(R.id.tvBD);
            tvKT=v.findViewById(R.id.tvKT);
            btnXoa=v.findViewById(R.id.btnXoa);
            tvMota=v.findViewById(R.id.tvMota);
            //set
            tvMaKH.setText(khoaHoc.maKH);
            tvTenKh.setText(khoaHoc.tenKH);
            tvBD.setText(khoaHoc.thoigianBD);
            tvKT.setText(khoaHoc.thoigianKT);
            tvMota.setText(khoaHoc.mota);


        }


        // click vao 1 item

//        v.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Toast.makeText(context, "Ban vua click dong " + position, Toast.LENGTH_SHORT).show();
////            }
////        });

        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //sua sach
                Intent intent = new Intent(context, KHActivity.class);

//                Bundle bundle = new Bundle();
//                bundle.putString("maKH", khoaHoc.maKH);
//                bundle.putString("tenKH", khoaHoc.tenKH);
//                bundle.putString("thoigianBD", khoaHoc.thoigianBD);
//                bundle.putString("thoigianKT", khoaHoc.thoigianKT);
//                bundle.putString("mota",khoaHoc.mota);

                intent.putExtra("maKH",tvMaKH.getText().toString());
                intent.putExtra("tenKH",tvTenKh.getText().toString());
                intent.putExtra("Mota",tvMota.getText().toString());
                intent.putExtra("thoigianBD",tvBD.getText().toString());
                intent.putExtra("thoigianKT",tvKT.getText().toString());


               getContext().startActivity(intent);

                return true;
            }
        });



        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             delete(khoaHoc);
            }
        });


        return v;
    }

    private void delete(KhoaHoc kh) {
        khdao.delete(kh);
        khoaHocs.remove(kh);
        notifyDataSetChanged();
        Toast.makeText(context, "da xoa", Toast.LENGTH_SHORT).show();
    }

}
