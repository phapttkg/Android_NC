package com.example.mob201_ps08944;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends Fragment implements OnMapReadyCallback {

    Button btnCS1, btnCS2, btnCS3;
    private GoogleMap mMap;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_maps, container, false);
        btnCS1=view.findViewById(R.id.btnCs1);
        btnCS2=view.findViewById(R.id.btnCs2);
        btnCS3=view.findViewById(R.id.btnCs3);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);

            mapFragment.getMapAsync(this);




       btnCS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng cs = new LatLng(10.7908587, 106.6799722);
                mMap.addMarker(new MarkerOptions().position(cs).title("FPOlY CS3"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cs, 10));
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            }
        });
        btnCS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LatLng cs = new LatLng(10.811857, 106.6777233);
                mMap.addMarker(new MarkerOptions().position(cs).title("FPOlY CS2"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cs, 10));
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


            }
        });
        btnCS3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng cs = new LatLng(10.8218969, 106.620833);
                mMap.addMarker(new MarkerOptions().position(cs).title("FPOlY CS3"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cs, 10));
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);





    }


}
