package com.example.myorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class order_pay extends AppCompatActivity {
    ImageView Backbutton;
    Button Order;
    Button Pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pay);

        Backbutton = findViewById(R.id.backbutton);
        Order = findViewById(R.id.Order);
        Pay = findViewById(R.id.pay);

        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one= new Intent(order_pay.this,Tables.class);
                startActivity(intent_one);
            }

        });

        Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one = new Intent(order_pay.this, Menu_.class);
                startActivity(intent_one);
            }

        });

        Pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one= new Intent(order_pay.this,payment_method.class);
                startActivity(intent_one);
            }

        });
    }
}