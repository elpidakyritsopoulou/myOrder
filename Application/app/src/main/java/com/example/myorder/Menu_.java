package com.example.myorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Menu_ extends AppCompatActivity {
    private Button button;

    FirebaseDatabase database;
    DatabaseReference menu;


    Button Home;
    ImageView Backbutton;
    Button Done;



    public void openDialog() {

        Home = findViewById(R.id.home);
        Backbutton = findViewById(R.id.backbutton);
        Done = findViewById(R.id.button_done);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one= new Intent(Menu_.this,Tables.class);
                startActivity(intent_one);
            }

        });

        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one= new Intent(Menu_.this,order_pay.class);
                startActivity(intent_one);
            }

        });

        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one= new Intent(Menu_.this,Order.class);
                startActivity(intent_one);
            }

        });


    }
}