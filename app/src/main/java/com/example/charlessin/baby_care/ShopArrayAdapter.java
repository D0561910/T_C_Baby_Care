package com.example.charlessin.baby_care;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ShopArrayAdapter extends ArrayAdapter<DataItem> {

    Context context;

    public ShopArrayAdapter(Context context, ArrayList<DataItem> items){
        super(context,0,items);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        LinearLayout itemlayout = null;
        if(convertView == null) {
            itemlayout = (LinearLayout)inflater.inflate(R.layout.listview_shop, null);
        } else {
            itemlayout = (LinearLayout) convertView;
        }

        DataItem item = (DataItem)getItem(position);

        TextView tv_name = (TextView) itemlayout.findViewById(R.id.tv_sBB_Name);
        tv_name.setText(item.getName());

        TextView tv_add = (TextView) itemlayout.findViewById(R.id.tv_sBB_Shelter);
        tv_add.setText(item.getShelter());

        TextView tv_tel = (TextView) itemlayout.findViewById(R.id.tv_sBB_Tel);
        tv_tel.setText(item.getbTel());

        TextView tv_px = (TextView) itemlayout.findViewById(R.id.tv_sBB_Px);
        tv_px.setText(item.getbPX());

        TextView tv_py = (TextView) itemlayout.findViewById(R.id.tv_sBB_Py);
        tv_py.setText(item.getbPY());

        return itemlayout;
    }
}
