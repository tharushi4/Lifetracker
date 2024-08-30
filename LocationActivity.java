package com.tharushi.lifetracker;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LocationActivity extends AppCompatActivity implements OnMapReadyCallback{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
}
    @Override
    public void onMapReady(@NonNull GoogleMap mMap) {
        mMap = mMap;
        LatLng location = new LatLng(6.89519844554669, 79.88120554042376);
        Marker marker = mMap.addMarker(new MarkerOptions().position(location).title("Marker Title"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12));

    }
}
