package com.example.myorder;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Menu_ extends AppCompatActivity {
    private Button button;

    FirebaseDatabase database;
    DatabaseReference menu;


    Button Home;
    ImageView Backbutton;
    Button Done;
    Button btn_quantity;



    public void openDialog() {

        Home = findViewById(R.id.home);
        Backbutton = findViewById(R.id.backbutton);
        Done = findViewById(R.id.button_done);
        btn_quantity = findViewById(R.id.btn_quantity1);

        btn_quantity.getBackground().setColorFilter(0XFFFF0000, PorterDuff.Mode.MULTIPLY);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one = new Intent(Menu_.this, Tables.class);
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