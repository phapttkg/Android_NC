package com.example.mob201_ps08944;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView nvgttrangchu;
    DrawerLayout drawerLauyout;
    Toolbar toolbar;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        drawerLauyout = findViewById(R.id.drwlayout);
        nvgttrangchu = findViewById(R.id.nvgttrangchu);
        View view = nvgttrangchu.getHeaderView(0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLauyout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLauyout.addDrawerListener(toggle);
        toggle.syncState();
//        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.RED));
        nvgttrangchu.setItemIconTintList(null);
        nvgttrangchu.setNavigationItemSelectedListener(this);


        getSupportFragmentManager().beginTransaction().replace(R.id.content, new KhoaHocFragment()).commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.lblKhoaHoc:
                getSupportFragmentManager().beginTransaction().replace(R.id.content, new KhoaHocFragment()).commit();
                break;
            case R.id.lblNew:
              Intent i= new Intent(this,NewsActivity.class);
              startActivity(i);
                break;
            case R.id.lblMap:
                getSupportFragmentManager().beginTransaction().replace(R.id.content, new MapsActivity()).commit();
                break;

//            case R.id.lblSocial:
//                getSupportFragmentManager().beginTransaction().replace(R.id.content, new XaHoiFragment()).commit();
//                break;

        }
        drawerLauyout.closeDrawer(GravityCompat.START);
        return true;
    }


}
