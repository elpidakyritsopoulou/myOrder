package com.example.myorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView Button;
    Button register;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button = findViewById(R.id.imageView4);
            register = findViewById(R.id.register);

            Button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent_one = new Intent(MainActivity.this, Staff.class);
                    startActivity(intent_one);

                }
            });

            register.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent_one = new Intent(MainActivity.this, Register.class);
                    startActivity(intent_one);

                }
            });

        }
    }
