package com.example.blooddonation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class QuestionnaireActivity extends AppCompatActivity {

    EditText etNomPrenom, etgroupBlood, etNumeroTelephone, etAdresse, surl;
    Button btnEnvoyer;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReferenceFromUrl("https://loginblood-default-rtdb.firebaseio.com/");




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_questionnaire);

        etNomPrenom = (EditText)findViewById(R.id.etNomPrenom);
        etNumeroTelephone = (EditText)findViewById(R.id.etNumeroTelephone);
        etAdresse = (EditText)findViewById(R.id.etAdresse);
        etgroupBlood = (EditText)findViewById(R.id.etgroupblood);

        btnEnvoyer = (Button)findViewById(R.id.btnEnvoyer);

        btnEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etNomPrenomtxt, etgroupBloodtxt, etNumeroTelephonetxt, etAdressetxt, surltxt;
                etNomPrenomtxt = etNomPrenom.getText().toString().trim();
                etgroupBloodtxt = etgroupBlood.getText().toString().trim();
                etAdressetxt = etAdresse.getText().toString().trim();
                etNumeroTelephonetxt = etNumeroTelephone.getText().toString().trim();
                surltxt = surl.getText().toString().trim();
                /*
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                User user = new User(etAdressetxt, etgroupBloodtxt, etNomPrenomtxt, etNumeroTelephonetxt, surltxt);
                reference.child("users").child("user5").setValue(user);
                */


                DatabaseReference usersRef = ref.child("users");

                Map<String, User> users = new HashMap<>();
                users.put("user10", new User(etAdressetxt,etgroupBloodtxt,etNomPrenomtxt,etNumeroTelephonetxt,surltxt));

                usersRef.setValue(users, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if (databaseError == null) {
                            // Data successfully saved
                            Toast.makeText(QuestionnaireActivity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(QuestionnaireActivity.this , ParametreActivity.class));
                            finish();

                        } else {
                            // Error occurred while saving data
                            Toast.makeText(QuestionnaireActivity.this, "Failed to save data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }
    /*private void insertData(){
        Map<String, Object> map = new HashMap<>();
        map.put("adresse",etAdresse.getText().toString());
        map.put("group_sanguin",etgroupBlood.getText().toString());
        map.put("nom_prénom",etNomPrenom.getText().toString());
        map.put("numero_phone",etNumeroTelephone.getText().toString());
        map.put("surl",surl.getText().toString());
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        FirebaseDatabase.getInstance().getReference("users").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(QuestionnaireActivity.this, "Votre demande a été ajoutée avec succès", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(QuestionnaireActivity.this, "Votre demande n'a pas été ajoutée avec succès", Toast.LENGTH_SHORT).show();
                    }
                });
    }*/

}
