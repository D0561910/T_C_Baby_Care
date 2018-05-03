package com.example.charlessin.baby_care;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_information;
    Button btn_shop;
    Button btn_center;
    Button btn_service;
    Button btn_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_information = findViewById(R.id.btn_Notify);
        btn_shop = findViewById(R.id.btn_Shop);
        btn_center = findViewById(R.id.btn_Resrc);
        btn_service = findViewById(R.id.btn_Service);
        btn_location = findViewById(R.id.btn_Location);

        btn_information.setOnClickListener(rec_info);
        btn_shop.setOnClickListener(rec_shop);
        btn_center.setOnClickListener(rec_center);
        btn_service.setOnClickListener(rec_service);
        btn_location.setOnClickListener(rec_loc);
    }

    private View.OnClickListener rec_info = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,InformationActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener rec_shop = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,ShopActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener rec_center = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,ResourceActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener rec_service = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,ServiceActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener rec_loc = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,AreaActivity.class);
            startActivity(intent);
        }
    };
}
