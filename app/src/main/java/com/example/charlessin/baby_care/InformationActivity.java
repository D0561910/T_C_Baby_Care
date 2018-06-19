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
 * 广告布告栏。
 */
public class InformationActivity extends AppCompatActivity {

    private InfoArrayAdapter adapter = null;

    private static final int BABY_INFO_LIST = 1;

    public static String KEY_TTL = "KEY_TTL";
    public static String KEY_IDA = "KEY_ID1";
    public static String KEY_IDB = "KEY_ID2";
    public static String KEY_IDC = "KEY_ID3";
    public static String KEY_IDD = "KEY_ID4";
    public static String KEY_IDE = "KEY_ID5";
    public static String KEY_IDF = "KEY_ID6";

    private Handler handler = new Handler(){
        public void handleMessage (Message msg){
            switch (msg.what){
                case BABY_INFO_LIST : {
                    List<InfoItem> baby = (List<InfoItem>) msg.obj;
                    refreshHotelList(baby);
                    break;
                }
            }
        }
    };

    private void refreshHotelList (List<InfoItem> babys){
        adapter.clear();
        adapter.addAll(babys);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        ListView lvResrc = (ListView)findViewById(R.id.info_lv);

        adapter = new InfoArrayAdapter(this, new ArrayList<InfoItem>());
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
            List<InfoItem> lsInfo = new ArrayList<>();
            for(DataSnapshot ds : dataSnapshot.getChildren()){
                DataSnapshot dsTitle = ds.child("InfoTitle");
                DataSnapshot dsClass = ds.child("Classification");
                DataSnapshot dsID1 = ds.child("InfoContext1");
                DataSnapshot dsID2 = ds.child("InfoContext2");
                DataSnapshot dsID3 = ds.child("InfoContext3");
                DataSnapshot dsID4 = ds.child("InfoContext4");
                DataSnapshot dsID5 = ds.child("InfoContext5");
                DataSnapshot dsID6 = ds.child("InfoContext6");

                String iTitle = (String) dsTitle.getValue();
                String iClass = (String) dsClass.getValue();
                String iID1 = (String) dsID1.getValue();
                String iID2 = (String) dsID2.getValue();
                String iID3 = (String) dsID3.getValue();
                String iID4 = (String) dsID4.getValue();
                String iID5 = (String) dsID5.getValue();
                String iID6 = (String) dsID6.getValue();

                InfoItem baby_List = new InfoItem();
                baby_List.setiTitle(iTitle);
                baby_List.setiClassification(iClass);
                baby_List.setiInfoContext1(iID1);
                baby_List.setiInfoContext2(iID2);
                baby_List.setiInfoContext3(iID3);
                baby_List.setiInfoContext3(iID4);
                baby_List.setiInfoContext3(iID5);
                baby_List.setiInfoContext3(iID6);
                lsInfo.add(baby_List);

                Log.v("babyDetails", iTitle + " : " + iClass + " : " + iID1 + " : " + iID2 + " : " + iID3 + " : " + iID4 + " : " + iID5 + " : " + iID6);

                Message msg = new Message();
                msg.what = BABY_INFO_LIST;
                msg.obj = lsInfo;
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
                Log.v("InfoDetails", databaseError.getMessage());
            }
        });
    }

    AdapterView.OnItemClickListener itemclick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            InfoItem info = (InfoItem) parent.getItemAtPosition(position);
            String ttl = info.getiTitle();
            String ic1 = info.getiInfoContext1();
            String ic2 = info.getiInfoContext2();
            String ic3 = info.getiInfoContext3();
            String ic4 = info.getiInfoContext4();
            String ic5 = info.getiInfoContext5();
            String ic6 = info.getiInfoContext6();

            Intent intent = new Intent();
            intent.setClass(InformationActivity.this,InformationListView.class);
            intent.putExtra(KEY_TTL, ttl);
            intent.putExtra(KEY_IDA, ic1);
            intent.putExtra(KEY_IDB, ic2);
            intent.putExtra(KEY_IDC, ic3);
            intent.putExtra(KEY_IDD, ic4);
            intent.putExtra(KEY_IDE, ic5);
            intent.putExtra(KEY_IDF, ic6);
            startActivity(intent);

        }
    };
}
