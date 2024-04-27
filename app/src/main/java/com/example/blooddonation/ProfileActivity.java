package com.example.blooddonation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    private LinearLayout besoinDeSangLinearLayout;
    private LinearLayout oudonnerLinearLayout;
    private LinearLayout aquidonnerLinearLayout;
    private LinearLayout mesrendezvousLinearLayout;
    private LinearLayout parametresLinearLayout ;
    private LinearLayout autoevaluationLinearLayout ;

    // Déclarez d'autres variables pour les autres LinearLayouts si nécessaire

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_profile);

        besoinDeSangLinearLayout = findViewById(R.id.besoin_de_sang_linear_layout);
        oudonnerLinearLayout = findViewById(R.id.ou_donner_linear_layout);
        aquidonnerLinearLayout = findViewById(R.id.aquidonner_linear_layout);
        mesrendezvousLinearLayout = findViewById(R.id.mesrendezvous_linear_layout);
        parametresLinearLayout = findViewById(R.id.parametres_linear_layout);
        autoevaluationLinearLayout = findViewById(R.id.evaluation_linear_layout);

        // Récupérez les références pour les autres LinearLayouts si nécessaire

        besoinDeSangLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action à effectuer lorsque le LinearLayout "Besoin de sang" est cliqué
                Intent intent = new Intent(ProfileActivity.this, QuestionnaireActivity.class);
                startActivity(intent);
            }
        });
        oudonnerLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action à effectuer lorsque le LinearLayout "Ou donner" est cliqué
                Intent intent = new Intent(ProfileActivity.this, MapsActivity.class);
                startActivity(intent);


            }
        });
        aquidonnerLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action à effectuer lorsque le LinearLayout "A qui donner" est cliqué
                Intent intent = new Intent(ProfileActivity.this, Recyclerview.class);
                startActivity(intent);

            }
        });
        mesrendezvousLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, RendezVousActivity.class);
                startActivity(intent);

            }
        });
        parametresLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action à effectuer lorsque le LinearLayout "Paramètres" est cliqué
                Intent intent = new Intent(ProfileActivity.this, ParametreActivity.class);
                startActivity(intent);

            }
        });

        autoevaluationLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Action à effectuer lorsque le LinearLayout "Auto-evulation" est cliqué
                Intent intent = new Intent(ProfileActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });
    }

}
