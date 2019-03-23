package com.example.a222;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public class SelectActivityFragment extends Fragment {
    public View myView;
    TextView selectedUser;
    String strtext;
    ImageButton usual;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        strtext = getArguments().getString("user");
        myView = inflater.inflate(R.layout.select_activity, null);
        selectedUser = myView.findViewById(R.id.selectedUser);
        selectedUser.setText(strtext);
        return myView;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        /*Intent intent = getIntent();
        String selectedUser = (String) intent.getSerializableExtra("user");

        user = (TextView)findViewById(R.id.selectedUser);
        user.setText(selectedUser);

        usual = (ImageButton) findViewById(R.id.usual);
        usual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent taskIntent = new Intent(SelectActivityFragment.this, TaskActivity.class);
                startActivity(taskIntent);
            }
        });*/
    }
}
