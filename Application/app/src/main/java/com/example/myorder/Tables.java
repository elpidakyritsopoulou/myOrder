package com.example.myorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Tables extends AppCompatActivity {
    ImageView Backbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

            Backbutton = findViewById(R.id.backbutton);


            Backbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent_one= new Intent(Tables.this,Staff.class);
                    startActivity(intent_one);
                }

            });
    }
}