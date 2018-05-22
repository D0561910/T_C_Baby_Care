package com.example.charlessin.baby_care;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * 友善商店。
 */
public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        ArrayList<DataItem> resourcelist = new ArrayList<DataItem>();
        resourcelist.add(new DataItem(R.drawable.baby_with_mom,"奇妮孕婦裝"));
        resourcelist.add(new DataItem(R.drawable.baby_with_mom,"棠棠媽咪"));
        resourcelist.add(new DataItem(R.drawable.baby_with_mom,"金寶貝"));
        resourcelist.add(new DataItem(R.drawable.baby_with_mom,"酷咕鴨嬰兒用品旗艦店"));
        resourcelist.add(new DataItem(R.drawable.baby_with_mom,"婴之房"));
        resourcelist.add(new DataItem(R.drawable.baby_with_mom,"ollobaby歐羅北鼻"));

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
