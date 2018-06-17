package com.example.charlessin.baby_care;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 托婴服务。
 */
public class NearbyActivity extends AppCompatActivity {

    Button carpark;
    Button service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);

        carpark = findViewById(R.id.car_park);
        service = findViewById(R.id.btn_serviceloc);

        carpark.setOnClickListener(parking);
        service.setOnClickListener(serviceloc);
    }


    private View.OnClickListener parking = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri =Uri.parse("geo:0,0?q=親子停車位");
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(uri);
            startActivity(intent);
        }
    };

    private View.OnClickListener serviceloc = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri =Uri.parse("geo:0,0?q=托婴服务");
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(uri);
            startActivity(intent);
        }
    };
}
