package com.example.charlessin.baby_care;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoArrayAdapter extends ArrayAdapter<InfoItem> {

    Context context;

    public InfoArrayAdapter(Context context, ArrayList<InfoItem> items){
        super(context,0,items);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        LinearLayout itemlayout = null;
        if(convertView == null) {
            itemlayout = (LinearLayout)inflater.inflate(R.layout.listview_resource, null);
        } else {
            itemlayout = (LinearLayout) convertView;
        }

        InfoItem item = (InfoItem)getItem(position);

        TextView tv_name = (TextView) itemlayout.findViewById(R.id.tv_iBB_Name);
        tv_name.setText(item.getiTitle());

        TextView tv_class = (TextView) itemlayout.findViewById(R.id.tv_iBB_Class);
        tv_class.setText(item.getiClassification());

        return itemlayout;
    }
}
