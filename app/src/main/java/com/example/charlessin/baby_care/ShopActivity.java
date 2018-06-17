package com.example.charlessin.baby_care;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 友善商店。
 */
public class ShopActivity extends AppCompatActivity {

    private ShopArrayAdapter adapter = null;

    private static final int BABY_SHOP_LIST = 1;

    public static String SHOP_KEY_PX = "KEY_PX";

    public static String SHOP_KEY_PY = "KEY_PY";

    private Handler handler = new Handler(){
        public void handleMessage (Message msg){
            switch (msg.what){
                case BABY_SHOP_LIST : {
                    List<DataItem> baby_shop = (List<DataItem>) msg.obj;
                    refreshHotelList(baby_shop);
                    break;
                }
            }
        }
    };

    private void refreshHotelList (List<DataItem> baby){
        adapter.clear();
        adapter.addAll(baby);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        ListView lvShop = (ListView)findViewById(R.id.shop_lv);
//        ArrayList<DataItem> resourcelist = new ArrayList<DataItem>();
//        resourcelist.add(new DataItem(R.drawable.shop_gennies, "奇妮孕婦裝"));
//        resourcelist.add(new DataItem(R.drawable.shop_tangtangmummy, "棠棠媽咪"));
//        resourcelist.add(new DataItem(R.drawable.shop_gbaby, "金寶貝"));
//        resourcelist.add(new DataItem(R.drawable.shop_kukuduck, "酷咕鴨嬰兒用品旗艦店"));
//        resourcelist.add(new DataItem(R.drawable.shop_infant, "婴之房"));
//        resourcelist.add(new DataItem(R.drawable.shop_ollobaby, "ollobaby歐羅北鼻"));

        adapter = new ShopArrayAdapter(this, new ArrayList<DataItem>());

        lvShop.setAdapter(adapter);
        lvShop.setOnItemClickListener(itemclick);

        getShopFromFireBase();
    }

    class FireBaseThread extends Thread{

        private DataSnapshot dataSnapshot;

        public FireBaseThread(DataSnapshot dataSnapshot){
            this.dataSnapshot = dataSnapshot;
        }

        public void run(){
            List<DataItem> lsShop = new ArrayList<>();
            for(DataSnapshot ds : dataSnapshot.getChildren()){
                DataSnapshot dsName = ds.child("SName");
                DataSnapshot dsAdd = ds.child("SAdd");
                DataSnapshot dsTel = ds.child("STel");
                DataSnapshot dsPx = ds.child("SPx");
                DataSnapshot dsPy = ds.child("SPy");

                String bbName = (String) dsName.getValue();
                String bbAdd = (String) dsAdd.getValue();
                String bbTel = (String) dsTel.getValue();
                String bbPx = (String) dsPx.getValue();
                String bbPy = (String) dsPy.getValue();

                DataItem baby_List = new DataItem();
                baby_List.setName(bbName);
                baby_List.setShelter(bbAdd);
                baby_List.setbTel(bbTel);
                baby_List.setbPX(bbPx);
                baby_List.setbPY(bbPy);
                lsShop.add(baby_List);
                Log.v("babyDetails", bbName + " : " + bbAdd + " : " + bbTel + " : " + bbPx + " : " + bbPy);

                Message msg = new Message();
                msg.what = BABY_SHOP_LIST;
                msg.obj = lsShop;
                handler.sendMessage(msg);
            }
        }
    }

    protected void getShopFromFireBase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                new FireBaseThread(dataSnapshot).start();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v("ShopDetails", databaseError.getMessage());
            }
        });
    }

    AdapterView.OnItemClickListener itemclick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            DataItem shop = (DataItem) parent.getItemAtPosition(position);
            String strX = shop.getbPX();
            String strY = shop.getbPY();

            Intent intent = new Intent();
            //intent.setClass(MainActivity.this);
            intent.putExtra(SHOP_KEY_PX, strX);
            intent.putExtra(SHOP_KEY_PY, strY);
            startActivity(intent);

        }
    };
}
