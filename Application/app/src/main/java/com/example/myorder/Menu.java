package com.example.myorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myorder.Model.Food;
import com.example.myorder.ViewHolder.FoodAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Menu extends AppCompatActivity implements FoodAdapter.OnFoodListener
//        implements NavigationView.OnNavigationItemSelectedListener
{
    private final FirebaseDatabase db = FirebaseDatabase.getInstance();
    ImageView Backbutton;
    FirebaseDatabase database;
    DatabaseReference category;
    private final DatabaseReference ref = db.getReference().child("Food");
    RecyclerView recyclerMenu;
    private FoodAdapter adapter;
    private ArrayList<Food> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recyclerMenu = findViewById(R.id.recycler_menu);
        Backbutton = findViewById(R.id.backbutton);
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one = new Intent(Menu.this, order_pay.class);
                startActivity(intent_one);
            }

        });

        recyclerMenu = findViewById(R.id.recycler_menu);
        recyclerMenu.setHasFixedSize(true);
        recyclerMenu.setLayoutManager(new LinearLayoutManager(recyclerMenu.getContext()));

        list = new ArrayList<Food>();
        adapter = new FoodAdapter(this, list, this);
        recyclerMenu.setAdapter(adapter);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Food food = dataSnapshot.getValue(Food.class);
                    list.add(food);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


    @Override
    public void onFoodClick(int position) {

    }
}