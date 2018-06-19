package com.example.charlessin.baby_care;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Double pX;
        Double pY;
        Intent intent = getIntent();
        String strX = null;
        String strY = null;
        strX = intent.getStringExtra(ResourceActivity.KEY_PX);
        strY = intent.getStringExtra(ResourceActivity.KEY_PY);
        pX = Double.valueOf(strX);
        pY = Double.valueOf(strY);
        if(strX==null && strY==null){
            String sStrX = intent.getStringExtra(ShopActivity.SHOP_KEY_PX);
            String sStrY = intent.getStringExtra(ShopActivity.SHOP_KEY_PY);
            pX = Double.valueOf(sStrX);
            pY = Double.valueOf(sStrY);
        }
        Log.d("String ","String : " + pX);
        Log.d("String ","String : " + pY);

        // Add a marker in Sydney and move the camera
        LatLng FCU = new LatLng(pX, pY);
        mMap.addMarker(new MarkerOptions().position(FCU).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(FCU));
    }
}
