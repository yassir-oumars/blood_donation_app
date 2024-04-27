package com.example.blooddonation;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        // Get the TextView
        TextView messageTextView = findViewById(R.id.messageTextView);

        // Set the success message
        messageTextView.setText("Bravo, d'après les informations indiquées, vous remplissez toutes les conditions pour donner votre sang !");
    }
}
