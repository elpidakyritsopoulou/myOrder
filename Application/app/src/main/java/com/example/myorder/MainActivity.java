package com.example.myorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button sign_in;
    Button register;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            sign_in = findViewById(R.id.SignIn);
            register = findViewById(R.id.register);

            sign_in.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent_one = new Intent(MainActivity.this, Tables.class);
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
