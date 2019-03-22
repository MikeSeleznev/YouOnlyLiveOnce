package com.example.a222;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {

    TextView user;
    ImageButton usual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_activity);

        Intent intent = getIntent();
        String selectedUser = (String) intent.getSerializableExtra("user");

        user = (TextView)findViewById(R.id.selectedUser);
        user.setText(selectedUser);

        usual = (ImageButton) findViewById(R.id.usual);
        usual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent taskIntent = new Intent(SelectActivity.this, TaskActivity.class);
                startActivity(taskIntent);
            }
        });
    }
}
