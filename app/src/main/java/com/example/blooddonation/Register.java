package com.example.blooddonation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
    // create object of DatabaseReference class to access firebase Realtime Database
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://loginblood-default-rtdb.firebaseio.com/");

    FirebaseAuth mAuth;
    ProgressBar progressBar;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        final EditText username = findViewById(R.id.usernamereg);
        final EditText password = findViewById(R.id.passwordreg);
        final EditText repassword = findViewById(R.id.repasswordreg);

        final Button registerbtn = findViewById(R.id.registerbtn);
        final Button button_login_now = findViewById(R.id.btn_login_now);
        progressBar =findViewById(R.id.progressBar);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                //get data from Edittext into String variables
                String usernametxt, passwordtxt, repasswordtxt;
                usernametxt = String.valueOf(username.getText()).trim();
                passwordtxt = String.valueOf(password.getText()).trim();
                repasswordtxt = String.valueOf(repassword.getText()).trim();

                //check if user fill all fields before sending to firebase

                if(usernametxt.isEmpty() || passwordtxt.isEmpty() || repasswordtxt.isEmpty()) {
                    Toast.makeText(Register.this, "Pleas fill all fields", Toast.LENGTH_SHORT).show();
                }

                //check if passwords are matching with each other
                else if(!passwordtxt.equals(repasswordtxt)){
                    Toast.makeText(Register.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
                }
                else{
                    mAuth.createUserWithEmailAndPassword(usernametxt, passwordtxt)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Register.this, "User register successfully", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Register.this , ProfileActivity.class));
                                        finish();

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(Register.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });

                }
            }
        });


        button_login_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Register.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}