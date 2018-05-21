package com.example.charlessin.baby_care;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * 资源中心。
 */
public class ResourceActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);

        ArrayList<ResData> resourcelist = new ArrayList<ResData>();
        resourcelist.add(new ResData(R.drawable.baby_with_mom,"XXXX"));
        resourcelist.add(new ResData(R.drawable.baby_with_mom,"XXXX"));
        resourcelist.add(new ResData(R.drawable.baby_with_mom,"XXXX"));
        resourcelist.add(new ResData(R.drawable.baby_with_mom,"XXXX"));
        resourcelist.add(new ResData(R.drawable.baby_with_mom,"XXXX"));
        resourcelist.add(new ResData(R.drawable.baby_with_mom,"XXXX"));
    }
}
