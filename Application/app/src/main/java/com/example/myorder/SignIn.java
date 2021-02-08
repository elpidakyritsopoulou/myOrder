package com.example.myorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
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

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        FirebaseAuth.AuthStateListener mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(SignIn.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignIn.this, Staff.class);
                    startActivity(i);
                } else {
                    Toast.makeText(SignIn.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                private Boolean validateUsername () {
                    String username_text = username.getText().toString();

                    if (username_text.isEmpty()) {
                        username.setError("Please enter User Name");
                        username.requestFocus();
                    } else if (username_text.length() >= 15) {
                        username.setError("Username too long");
                    }
                }
                private Boolean validatePassword () {
                    String password_text = password.getText().toString();
                    if (password_text.isEmpty()) {
                        password.setError("Please enter your password");
                        password.requestFocus();
                    }
                }
                public void loginUser (View v){
                    if (!validateUsername | validatePassword)){
                        return;
                    } else{
                        isUser();
                    }
                }


            }
        });
    }

    private void isUser() {
        String userEnteredUsername = username.getText().toString().trim();
        String userEnteredPassword = password.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Restaurant");

        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    String passwordDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);

                    if (passwordDB.equals(userEnteredPassword)) {
                        Intent intent = new Intent(getApplicationContext(), SignIn.class);
                        startActivity(intent);
                    } else {
                        password.setError("Wrong Password");
                    }
                } else {
                    username.setError("No such User exist");
                    username.requestFocus();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


    }

}

