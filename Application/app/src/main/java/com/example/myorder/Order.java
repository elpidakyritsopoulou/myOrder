package com.example.myorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Order extends AppCompatActivity {
    private

    ImageView Cancel;
    ImageView Backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);

        Cancel= findViewById(R.id.cancel_button);
        Backbutton= findViewById(R.id.backbutton);

        Cancel.setOnClickListener(new  View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_one = new Intent(Order.this, Staff.class);
                startActivity(intent_one);

            }
        });
        Backbutton.setOnClickListener(new  View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_one = new Intent(Order.this, Staff.class);
                startActivity(intent_one);

            }
        });


    }


}