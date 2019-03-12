package com.example.a222;

import android.content.Context;
import android.content.Intent;
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
    Button startGame;
    Button add2;
    EditText newUser;
    MyListAdapter myListAdapter;

    final ArrayList<String> gamersArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);

        gamersListView = (ListView) findViewById(R.id.gamers);
        myListAdapter = new MyListAdapter(this, R.layout.list_row, gamersArray);
        gamersListView.setAdapter(myListAdapter);
        newUser = (EditText) findViewById(R.id.newUser);
        startGame = (Button) findViewById(R.id.startGame);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GamezoneActivity.class);
                startActivity(intent);
            }
        });

        add2 = (Button) findViewById(R.id.add2);
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString = newUser.getText().toString();
                if (!inputString.equals("")) {
                    gamersArray.add(inputString);
                    myListAdapter.notifyDataSetChanged();
                    newUser.setText("");
                }

                setEnterItemVisible();
            }
        });
    }


    private class MyListAdapter extends ArrayAdapter<String> {
        private int layout;

        private MyListAdapter(Context context, int resource, ArrayList<String> objects) {
            super(context, resource, objects);
            layout = resource;
        }


        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewholder = null;
            if (convertView == null) {
                ViewHolder viewholder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                viewholder.title = (TextView) convertView.findViewById(R.id.title);
                viewholder.button = (ImageButton) convertView.findViewById(R.id.DeleteUser);
                viewholder.title.setText(getItem(position));
                viewholder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gamersArray.remove(position);
                        myListAdapter.notifyDataSetChanged();
                        setEnterItemVisible();
                    }
                });

                convertView.setTag(viewholder);

            } else {
                mainViewholder = (ViewHolder) convertView.getTag();
                mainViewholder.title.setText(getItem(position));
            }
            return convertView;

        }
    }

    private void setEnterItemVisible() {
        boolean check = true;
        if (gamersArray.size() >= 8) {
            check = false;
        }
        newUser.setEnabled(check);
        add2.setEnabled(check);
    }

    public class ViewHolder {

        TextView title;
        ImageButton button;
    }

}
