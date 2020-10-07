package com.example.smarthome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoodsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double c1;
    private double c2;
    private String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("desc");
        String id =    getIntent().getStringExtra("id");
        c1 = getIntent().getDoubleExtra("c1",0);
        c2 = getIntent().getDoubleExtra("c2",0);
        TextView t = findViewById(R.id.textView);
        t.setText(desc);
        getSupportActionBar().setTitle(title);


    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng place = new LatLng(c1, c2);
        mMap.addMarker(new MarkerOptions().position(place).title(title));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place, 17F));

    }
}