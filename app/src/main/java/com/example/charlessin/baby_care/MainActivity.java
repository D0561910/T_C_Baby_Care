package com.example.charlessin.baby_care;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/**
 * Main Program.
 */
public class MainActivity extends AppCompatActivity {

    Button btn_information;
    Button btn_shop;
    Button btn_center;
    Button btn_service;
    Button btn_location;
    ViewFlipper v_Flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[] = {R.drawable.ssbbca,R.drawable.ssbbcb,R.drawable.ssbbcc,R.drawable.ssbbcg,R.drawable.ssbbch};

        btn_information = findViewById(R.id.btn_Notify);
        btn_shop = findViewById(R.id.btn_Shop);
        btn_center = findViewById(R.id.btn_Resrc);
        btn_service = findViewById(R.id.btn_Service);
        btn_location = findViewById(R.id.btn_SrvcArea);
        v_Flipper = findViewById(R.id.v_flipper);

        for(int image : images){
            flipperImages(image);
        }

        btn_information.setOnClickListener(rec_info);
        btn_shop.setOnClickListener(rec_shop);
        btn_center.setOnClickListener(rec_center);
        btn_service.setOnClickListener(rec_service);
        btn_location.setOnClickListener(rec_loc);
    }

    public void flipperImages (int images){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        v_Flipper.addView(imageView);
        v_Flipper.setFlipInterval(4000);
        v_Flipper.setAutoStart(true);

        v_Flipper.setInAnimation(this,android.R.anim.slide_out_right);
        v_Flipper.setOutAnimation(this,android.R.anim.slide_in_left);
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
            intent.setClass(MainActivity.this,NearbyActivity.class);
            startActivity(intent);
        }
    };
}
