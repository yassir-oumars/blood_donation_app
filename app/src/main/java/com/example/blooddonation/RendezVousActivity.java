package com.example.blooddonation;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RendezVousActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendezvous);

        TextView textViewMessage = findViewById(R.id.textViewMessage);
        textViewMessage.setText("Vous n'avez encore aucun rendez-vous");
    }
}

