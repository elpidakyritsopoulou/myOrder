package com.example.myorder;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Staff extends AppCompatActivity {

    Button Staff1;
    Button Staff2;
    Button Staff3;
    Button Staff4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);

        Staff1 = findViewById(R.id.Staff1);
        Staff2 = findViewById(R.id.Staff2);
        Staff3 = findViewById(R.id.Staff3);
        Staff4 = findViewById(R.id.Staff4);


        Staff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one= new Intent(Staff.this,Tables.class);
                startActivity(intent_one);
            }

        });

        Staff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one= new Intent(Staff.this,Tables.class);
                startActivity(intent_one);
            }

        });

        Staff3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one= new Intent(Staff.this,Tables.class);
                startActivity(intent_one);
            }

        });

        Staff3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one= new Intent(Staff.this,Tables.class);
                startActivity(intent_one);
            }

        });

        Staff4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one= new Intent(Staff.this,Tables.class);
                startActivity(intent_one);
            }

        });



    }
}