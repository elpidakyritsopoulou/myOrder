package com.example.myorder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText restaurant_name;
    EditText username;
    EditText phone;
    EditText email;
    EditText password;
    Button done2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        restaurant_name = findViewById(R.id.restaurant_name);
        username = findViewById(R.id.username);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        done2 = findViewById(R.id.done2);

        mAuth = FirebaseAuth.getInstance();

        done2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String restaurant_name_text = restaurant_name.getText().toString().trim();
                String username_text = username.getText().toString().trim();
                String phone_text = phone.getText().toString().trim();
                String email_text = email.getText().toString().trim();
                String password_text = password.getText().toString().trim();


                mAuth.createUserWithEmailAndPassword(email_text, password_text)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Restaurant restaurant = new Restaurant(restaurant_name_text, username_text, phone_text, email_text, password_text);

                                    FirebaseDatabase.getInstance().getReference("Restaurant")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(restaurant).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(Register.this, "Η εγγραφή ολοκληρώθηκε!", Toast.LENGTH_SHORT).show();
                                            } else {
                                                Toast.makeText(Register.this, "Σφάλμα!", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });

                                } else {
                                    Toast.makeText(Register.this, "ERROR", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}