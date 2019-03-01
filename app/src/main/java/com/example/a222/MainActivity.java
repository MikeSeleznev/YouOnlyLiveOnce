package com.example.a222;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView gamersListView;
    Button add2;
    EditText newUser;
    MyListAdapter myListAdapter;

    ListOfGamers gamersArray = new ListOfGamers();
    ArrayAdapter adapter;
    //MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);

        gamersListView = (ListView) findViewById(R.id.gamers);
        myListAdapter = new MyListAdapter(this, R.layout.list_row, gamersArray.getNames());
        gamersListView.setAdapter(myListAdapter);
        newUser = (EditText) findViewById(R.id.newUser);

        add2 = (Button) findViewById(R.id.add2);
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString = newUser.getText().toString();
                if (!inputString.equals("")) {
                    gamersArray.add(newUser.getText().toString());
                    myListAdapter.notifyDataSetChanged();
                    newUser.setText("");
                }

                if (gamersArray.size() == 8) {
                    newUser.setEnabled(false);
                    add2.setEnabled(false);
                    MakeToast();
                }
            }
        });
    }

    private class MyListAdapter extends ArrayAdapter<String> {
        private int layout;
        private ArrayList<String> mObjects;

        private MyListAdapter(Context context, int resource, ArrayList<String> objects) {
            super(context, resource, objects);
            mObjects = objects;
            layout = resource;
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewholder = null;
            if (convertView == null) {
                for (String s : gamersArray.getNames()) {
                    LayoutInflater inflater = LayoutInflater.from(getContext());
                    convertView = inflater.inflate(layout, parent, false);
                    TextView title = (TextView) convertView.findViewById(R.id.title);
                    ImageButton deleteButton = (ImageButton) convertView.findViewById(R.id.DeleteUser);
                    deleteButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gamersArray.remove(position);
                            ArrayList temp = (ArrayList) gamersArray.getNames().clone();
                            gamersArray.getNames().clear();
                            gamersArray.getNames().addAll(temp);
                            notifyDataSetChanged();
                        }
                    });
                    title.setText(s);
                    ViewHolder viewHolder = new ViewHolder();
                    viewHolder.title = title;
                    viewHolder.button = deleteButton;
                    convertView.setTag(viewHolder);
                }
                /*mainViewholder = (ViewHolder) convertView.getTag();
                mainViewholder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gamersArray.remove(position);
                        ArrayList temp = (ArrayList) gamersArray.getNames().clone();
                        gamersArray.getNames().clear();
                        gamersArray.getNames().addAll(temp);


                        //gamersListView.setAdapter(myListAdapter);
                        // myListAdapter.remove(gamersArray.getNames(position));
                        //myListAdapter.remove(myListAdapter.getItem(position).toString());
                        notifyDataSetChanged();

                    }
                });*/

            }
            return convertView;
        }
    }

    public class ViewHolder {

        ImageView thumbnail;
        TextView title;
        ImageButton button;
    }

    public void MakeToast() {
        Toast toast = Toast.makeText(this, "Введено макскимальное количество игроков", Toast.LENGTH_SHORT);
        toast.show();
    }
}
