package com.example.myorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Menu extends AppCompatActivity
//        implements NavigationView.OnNavigationItemSelectedListener
{
    ImageView Backbutton;
    FirebaseDatabase database;
    DatabaseReference category;

    LinearLayout recycler_menu;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Backbutton = findViewById(R.id.backbutton);

        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_one = new Intent(Menu.this, order_pay.class);
                startActivity(intent_one);
            }

        });

        //Init Firebase
        database = FirebaseDatabase.getInstance();
        category = database.getReference("Category");
//Load Menu
//        recycler_menu = (RecyclerView)findViewById(R.id.recycler_menu);
//        recycler_menu.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        recycler_menu.setLayoutManager(layoutManager);

//        loadMenu();
//    }

//    private void loadMenu() {
//
//        FirebaseRecyclerAdapter<Category, MenuViewHolder> adapter = new FirebaseRecyclerAdapter<Category, MenuViewHolder>(Category.class,R.layout.activity_menu,MenuViewHolder.class,category) {
//            @Override
//            protected void onBindViewHolder(@NonNull MenuViewHolder holder, int position, @NonNull Category model) {
//               viewHolder.txtMenuName.setText(model.getName());
//                Picasso.with(getBaseContext()).load(model.getImage())
//                        .into(viewHolder.imageView);
//                Category clickItem = model;
//                createViewHolder().setItemClickListener() {
//
//                }
//            }
//
//            @NonNull
//            @Override
//            public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                return null;
//            }
//
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        return false;
//    }
    }
}