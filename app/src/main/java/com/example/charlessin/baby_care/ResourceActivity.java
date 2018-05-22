package com.example.charlessin.baby_care;

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

        ArrayList<DataItem> resourcelist = new ArrayList<DataItem>();
        resourcelist.add(new DataItem(R.drawable.baby_with_mom,"XXXX"));
        resourcelist.add(new DataItem(R.drawable.baby_with_mom,"XXXX"));
        resourcelist.add(new DataItem(R.drawable.baby_with_mom,"XXXX"));
        resourcelist.add(new DataItem(R.drawable.baby_with_mom,"XXXX"));
        resourcelist.add(new DataItem(R.drawable.baby_with_mom,"XXXX"));
        resourcelist.add(new DataItem(R.drawable.baby_with_mom,"XXXX"));

        ItemArrayAdapter adapter =
                new ItemArrayAdapter(this, resourcelist);

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
