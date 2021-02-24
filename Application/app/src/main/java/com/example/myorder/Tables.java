package com.example.myorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class Tables extends AppCompatActivity {
    ImageView Backbutton;
    Button Table1;
    Button Table2;
    Button Table3;
    Button Table4;


    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);


            Backbutton = findViewById(R.id.backbutton);
            Table1 = findViewById(R.id.table_1_);
            Table2 = findViewById(R.id.table_2_);
            Table3 = findViewById(R.id.table_3_);
            Table4 = findViewById(R.id.table_4_);
            Table1 = (Button) findViewById(R.id.table_1_);

        Backbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent_one= new Intent(Tables.this,Staff.class);
                    startActivity(intent_one);

                    Table1.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            Intent i = new Intent(getApplicationContext(),PopActivity.class);
                            startActivity(i);
                            return false;
                        }
                    });

                }

            });

        Table1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one= new Intent(Tables.this,order_pay.class);
                startActivity(intent_one);
            }

        });

        Table2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one= new Intent(Tables.this,order_pay.class);
                startActivity(intent_one);
            }

        });

        Table3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one= new Intent(Tables.this,order_pay.class);
                startActivity(intent_one);
            }

        });

        Table4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one = new Intent(Tables.this, order_pay.class);
                startActivity(intent_one);
            }

        });

    }

}