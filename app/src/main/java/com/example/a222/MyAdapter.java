package com.example.a222;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter implements ListAdapter{
        private ArrayList<String> mArrayList = new ArrayList<String>();
        private Context context;



    public MyAdapter(ArrayList<String> list, Context context){
        this.mArrayList = list;
        this.context = context;
    }

    public void setModel(ArrayList<String> arrayList){
        this.mArrayList = arrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //if (convertView == null){
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = LayoutInflater.from(context).inflate(R.layout.list_row,parent, false);
           // convertView = inflater.inflate(R.layout.list_row, null);
        //}

        //TextView title = (TextView) convertView.findViewById(R.id.title);
        //ImageView deleteImage = (ImageView) convertView.findViewById(R.id.deleteImage);

        //title.setText("Тест");
        return convertView;
    }
}
