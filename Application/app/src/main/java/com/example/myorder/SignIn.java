package com.example.myorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignIn extends AppCompatActivity {

    EditText username;
    EditText password;
    ImageView login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(SignIn.this, Staff.class);
                startActivity(myIntent);
            }
        });

//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent myIntent = new Intent(SignIn.this, Menu.class);
//                startActivity(myIntent);
//
//
//                ProgressDialog mDialog = new ProgressDialog(SignIn.this);
//                mDialog.setMessage("Please wait");
//                mDialog.show();
//
//
//                table_user.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                        //Check if user not exist in database
//                        if (snapshot.child(username.getText().toString()).exists()) {
//                            // Get User Information
//                            mDialog.dismiss();
//                            User user = snapshot.child(username.getText().toString()).getValue(User.class);
//                            if (user.getPassword().equals((password.getText().toString()))) {
//                                Intent myIntent = new Intent(SignIn.this, Staff.class);
//                                startActivity(myIntent);
//                                finish();
//                                Toast.makeText(SignIn.this, "Sign in successfully!", Toast.LENGTH_SHORT).show();
//
//
//                            } else {
//                                Toast.makeText(SignIn.this, "Sign in failed!", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Toast.makeText(SignIn.this, "User does not exist ", Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//            }
//
//
//        });


    }

}


