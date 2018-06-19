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

import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * 资源中心。
 */
public class ResourceActivity extends AppCompatActivity {

    private ItemArrayAdapter adapter = null;

    private static final int BABYS_LIST = 1;

    public static String KEY_PX = "KEY_PX";

    public static String KEY_PY = "KEY_PY";

    private Handler handler = new Handler(){
        public void handleMessage (Message msg){
            switch (msg.what){
                case BABYS_LIST : {
                    List<DataItem> baby = (List<DataItem>) msg.obj;
                    refreshHotelList(baby);
                    break;
                }
            }
        }
    };

    private void refreshHotelList (List<DataItem> babys){
        adapter.clear();
        adapter.addAll(babys);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);

        ListView lvResrc = (ListView)findViewById(R.id.res_lv);

        adapter = new ItemArrayAdapter(this, new ArrayList<DataItem>());
        lvResrc.setAdapter(adapter);
        lvResrc.setOnItemClickListener(itemclick);

        getFromFireBase();
    }

    class FireBaseThread extends Thread{

        private DataSnapshot dataSnapshot;

        public FireBaseThread(DataSnapshot dataSnapshot){
            this.dataSnapshot = dataSnapshot;
        }

        public void run(){
            List<DataItem> lsRsrc = new ArrayList<>();
            for(DataSnapshot ds : dataSnapshot.getChildren()){
                DataSnapshot dsName = ds.child("RName");
                DataSnapshot dsAdd = ds.child("RAdd");
                DataSnapshot dsTel = ds.child("RTel");
                DataSnapshot dsPx = ds.child("RPx");
                DataSnapshot dsPy = ds.child("RPy");

                String bbName = (String) dsName.getValue();
                String bbAdd = (String) dsAdd.getValue();
                String bbTel = (String) dsTel.getValue();
                String bbPx = (String) dsPx.getValue();
                String bbPy = (String) dsPy.getValue();

                //DataSnapshot dsImg = ds.child("Picture1");
                //String imgUrl = (String) dsImg.getValue();
                //Bitmap hotelImg = getImgBitmap(imgUrl);

                DataItem baby_List = new DataItem();
                baby_List.setName(bbName);
                baby_List.setShelter(bbAdd);
                baby_List.setbTel(bbTel);
                baby_List.setbPX(bbPx);
                baby_List.setbPY(bbPy);
                //nHotels.setImgUrl(hotelImg);
                lsRsrc.add(baby_List);
                Log.v("babyDetails", bbName + " : " + bbAdd + " : " + bbTel + " : " + bbPx + " : " + bbPy);

                Message msg = new Message();
                msg.what = BABYS_LIST;
                msg.obj = lsRsrc;
                handler.sendMessage(msg);
            }
        }
    }

    protected void getFromFireBase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                new FireBaseThread(dataSnapshot).start();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v("ResourceDetails", databaseError.getMessage());
            }
        });
    }

    AdapterView.OnItemClickListener itemclick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            DataItem rSrc = (DataItem) parent.getItemAtPosition(position);
            String strX = rSrc.getbPX();
            String strY = rSrc.getbPY();

            Intent intent = new Intent();
            intent.setClass(ResourceActivity.this,MapsActivity.class);
            intent.putExtra(KEY_PX, strX);
            intent.putExtra(KEY_PY, strY);
            startActivity(intent);
        }
    };
}
