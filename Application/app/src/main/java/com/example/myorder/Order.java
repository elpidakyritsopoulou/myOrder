package com.example.myorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Order extends AppCompatActivity {

    ImageView Button;
    ImageView Backbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);

        Button = findViewById(R.id.check);
        Backbutton= findViewById(R.id.backbutton);

        Button.setOnClickListener(new  View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_one = new Intent(Order.this, payment_method.class);
                startActivity(intent_one);

            }
        });
        Backbutton.setOnClickListener(new  View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_one = new Intent(Order.this, Menu.class);
                startActivity(intent_one);

            }
        });



    }

}