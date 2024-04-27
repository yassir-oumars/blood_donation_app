package com.example.blooddonation;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FailureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failure);

        // Get the TextView
        TextView messageTextView = findViewById(R.id.messageTextView);

        // Set the failure message
        messageTextView.setText("Malheureusement, d'après les informations indiquées, vous ne remplissez pas toutes les conditions pour donner votre sang.");
    }
}
