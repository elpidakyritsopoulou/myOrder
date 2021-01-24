package com.example.myorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
                String username_text = username.getText().toString();
                String password_text = password.getText().toString();

               if (username_text.isEmpty()) {
                    username.setError("Please enter User Name");
                    username.requestFocus();
                } else if (password_text.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                } else if (username_text.isEmpty() || password_text.isEmpty()) {
                    Toast.makeText(SignIn.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                } else if (!(username_text.isEmpty()) && (password_text.isEmpty())) {
                    mAuth.createUserWithEmailAndPassword(username_text, password_text).addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignIn.this, "Login Error, Please Login Again", Toast.LENGTH_SHORT).show();
                           } else {
                                Intent intToHome = new Intent(SignIn.this, MainActivity.class);
                                startActivity(intToHome);
                           }
                        }
                    });
               } else {
                    Toast.makeText(SignIn.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }


            }

        });
    }

}