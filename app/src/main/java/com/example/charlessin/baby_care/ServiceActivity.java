package com.example.charlessin.baby_care;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 拖婴地区。
 */
public class ServiceActivity extends AppCompatActivity {

    Button north;
    Button west;
    Button south;
    Button dali;
    Button fengyuan;
    Button shalu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        north = findViewById(R.id.btn_North);
        west = findViewById(R.id.btn_West);
        south = findViewById(R.id.btn_South);
        dali = findViewById(R.id.btn_Dali);
        fengyuan = findViewById(R.id.btn_Fengyuan);
        shalu = findViewById(R.id.btn_Shalu);

        south.setOnClickListener(call_South);
        north.setOnClickListener(call_North);
        west.setOnClickListener(call_West);
        dali.setOnClickListener(call_Dali);
        fengyuan.setOnClickListener(call_Fengyuan);
        shalu.setOnClickListener(call_shalu);
    }
    private View.OnClickListener call_South = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("geo:0,0?q=臺中市南屯區東興路2段98號8樓");
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(uri);
            startActivity(intent);
        }
    };
    private View.OnClickListener call_North = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("geo:0,0?q=臺中市北區學士路91號");
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(uri);
            startActivity(intent);
        }
    };
    private View.OnClickListener call_West = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("geo:0,0?q=臺中市西屯區光明路160號2樓");
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(uri);
            startActivity(intent);
        }
    };
    private View.OnClickListener call_Dali = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("geo:0,0?q=臺中市大里區國光路二段500號5樓之4");
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(uri);
            startActivity(intent);
        }
    };
    private View.OnClickListener call_Fengyuan = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("geo:0,0?q=臺中市豐原區西安街36號5樓");
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(uri);
            startActivity(intent);
        }
    };
    private View.OnClickListener call_shalu = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("geo:0,0?q=臺中市沙鹿區福幼街8號3樓");
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(uri);
            startActivity(intent);
        }
    };

}
