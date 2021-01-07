package com.example.myorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class payment_method extends AppCompatActivity {

   ImageView Button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        Button2 = findViewById(R.id.backbutton1);

        Button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent_one = new Intent(payment_method.this, Order.class);
                startActivity(intent_one);

            }
        });

    }
}