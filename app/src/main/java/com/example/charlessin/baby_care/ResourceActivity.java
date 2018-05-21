package com.example.charlessin.baby_care;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * 资源中心。
 */
public class ResourceActivity extends AppCompatActivity {

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

        ResourceArrayAdapter adapter =
                new ResourceArrayAdapter(this, resourcelist);

        ListView lv = (ListView)findViewById(R.id.res_lv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(itemclick);
    }

    AdapterView.OnItemClickListener itemclick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    };
}
