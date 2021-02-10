package com.example.myorder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myorder.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {

    EditText username;
    EditText password;
    ImageView login;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username = findViewById(R.id.edtPhone);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please wait");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        //Check if user not exist in database
                        if (snapshot.child(username.getText().toString()).exists()) {


                            // Get User Information
                            mDialog.dismiss();
                            User user = snapshot.child(username.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals((password.getText().toString()))) {
                                Toast.makeText(SignIn.this, "Sign in successfully!", Toast.LENGTH_SHORT).show();
                                Intent signin = new Intent(SignIn.this, Menu.class);
                                startActivity(signin);
                            } else {
                                Toast.makeText(SignIn.this, "Sign in failed!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SignIn.this, "User does not exist ", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }

        });


    }

}


