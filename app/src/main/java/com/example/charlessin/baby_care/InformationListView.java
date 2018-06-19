package com.example.charlessin.baby_care;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InformationListView extends AppCompatActivity {

    TextView inTt;
    TextView inA;
    TextView inB;
    TextView inC;
    TextView inD;
    TextView inE;
    TextView inF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_list_view);

        inTt = findViewById(R.id.tv_Title);
        inA = findViewById(R.id.tv_Info_contextA);
        inB = findViewById(R.id.tv_Info_contextB);
        inC = findViewById(R.id.tv_Info_contextC);
        inD = findViewById(R.id.tv_Info_contextD);
        inE = findViewById(R.id.tv_Info_contextE);
        inF = findViewById(R.id.tv_Info_contextF);

        Intent intent = getIntent();

        String infoT = intent.getStringExtra(InformationActivity.KEY_TTL);
        String infoA = intent.getStringExtra(InformationActivity.KEY_IDA);
        String infoB = intent.getStringExtra(InformationActivity.KEY_IDA);
        String infoC = intent.getStringExtra(InformationActivity.KEY_IDA);
        String infoD = intent.getStringExtra(InformationActivity.KEY_IDA);
        String infoE = intent.getStringExtra(InformationActivity.KEY_IDA);
        String infoF = intent.getStringExtra(InformationActivity.KEY_IDA);

        inTt.setText(infoT);
        inA.setText(infoA);
        inB.setText(infoB);
        inC.setText(infoC);
        inD.setText(infoD);
        inE.setText(infoE);
        inF.setText(infoF);
    }
}
