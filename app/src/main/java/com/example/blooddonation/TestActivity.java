package com.example.blooddonation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {

    private RadioGroup genderRadioGroup;
    private RadioGroup ageRadioGroup;
    private RadioGroup weightRadioGroup;
    private RadioGroup donationRadioGroup;
    private RadioGroup hivRadioGroup;
    private RadioGroup cancerRadioGroup;
    private RadioGroup chronicDiseaseRadioGroup;
    private RadioGroup chestPainRadioGroup;
    private RadioGroup transfusionRadioGroup;
    private RadioGroup drugsTattooRadioGroup;
    private RadioGroup anemiaRadioGroup;
    private RadioGroup surgeryRadioGroup;
    private RadioGroup feverRadioGroup;
    private RadioGroup dentalCareRadioGroup;
    private RadioGroup medicationRadioGroup;

    private Button nextButton;
    private Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // Initialize views
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        ageRadioGroup = findViewById(R.id.ageRadioGroup);
        weightRadioGroup = findViewById(R.id.weightRadioGroup);
        donationRadioGroup = findViewById(R.id.lastDonationRadioGroup);
        hivRadioGroup = findViewById(R.id.hivHepatitisRadioGroup);
        cancerRadioGroup = findViewById(R.id.cancerRadioGroup);
        chronicDiseaseRadioGroup = findViewById(R.id.chronicDiseaseRadioGroup);
        chestPainRadioGroup = findViewById(R.id.chestPainRadioGroup);
        transfusionRadioGroup = findViewById(R.id.transfusionOrganRadioGroup);
        drugsTattooRadioGroup = findViewById(R.id.drugsTattooRadioGroup);
        anemiaRadioGroup = findViewById(R.id.anemiaRadioGroup);
        surgeryRadioGroup = findViewById(R.id.surgeryRadioGroup);
        feverRadioGroup = findViewById(R.id.feverRadioGroup);
        dentalCareRadioGroup = findViewById(R.id.dentalCareRadioGroup);
        medicationRadioGroup = findViewById(R.id.medicationRadioGroup);

        nextButton = findViewById(R.id.nextButton);
        restartButton = findViewById(R.id.restartButton);

        // Set click listener for the next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAllAnswersCorrect()) {
                    // Afficher la page de succès si toutes les réponses sont correctes
                    Intent successIntent = new Intent(TestActivity.this, SuccessActivity.class);
                    startActivity(successIntent);
                } else {
                    // Afficher la page d'échec si au moins une réponse est incorrecte
                    Intent failureIntent = new Intent(TestActivity.this, FailureActivity.class);
                    startActivity(failureIntent);
                }
            }
        });


        // Set click listener for the restart button
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset all radio button selections
                genderRadioGroup.clearCheck();
                ageRadioGroup.clearCheck();
                weightRadioGroup.clearCheck();
                donationRadioGroup.clearCheck();
                hivRadioGroup.clearCheck();
                cancerRadioGroup.clearCheck();
                chronicDiseaseRadioGroup.clearCheck();
                chestPainRadioGroup.clearCheck();
                transfusionRadioGroup.clearCheck();
                drugsTattooRadioGroup.clearCheck();
                anemiaRadioGroup.clearCheck();
                surgeryRadioGroup.clearCheck();
                feverRadioGroup.clearCheck();
                dentalCareRadioGroup.clearCheck();
                medicationRadioGroup.clearCheck();
            }
        });
    }

    private boolean isAllAnswersCorrect() {
        // Check if all questions have been answered correctly
        return isAnswerCorrect(genderRadioGroup) &&
                isAnswerCorrect(ageRadioGroup) &&
                isAnswerCorrect(weightRadioGroup) &&
                isAnswerCorrect(donationRadioGroup) &&
                isAnswerCorrect(hivRadioGroup) &&
                isAnswerCorrect(cancerRadioGroup) &&
                isAnswerCorrect(chronicDiseaseRadioGroup) &&
                isAnswerCorrect(chestPainRadioGroup) &&
                isAnswerCorrect(transfusionRadioGroup) &&
                isAnswerCorrect(drugsTattooRadioGroup) &&
                isAnswerCorrect(anemiaRadioGroup) &&
                isAnswerCorrect(surgeryRadioGroup) &&
                isAnswerCorrect(feverRadioGroup) &&
                isAnswerCorrect(dentalCareRadioGroup) &&
                isAnswerCorrect(medicationRadioGroup);
    }

    private boolean isAnswerCorrect(RadioGroup radioGroup) {
        // Check if the selected answer is correct
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton radioButton = findViewById(selectedId);
            String selectedText = radioButton.getText().toString();
            // Here you can define the correct answer for each question
            // and compare it with the selected answer
            // Return true if the answer is correct, false otherwise
            // For example:
            if (radioGroup == genderRadioGroup) {
                return selectedText.equals("Homme") || selectedText.equals("Femme");
            } else if (radioGroup == ageRadioGroup) {
                return selectedText.equals("18 à 70 ans") || selectedText.equals("71 ans et plus");
            } else if (radioGroup == weightRadioGroup) {
                return selectedText.equals("50 kg et plus");
            } else if (radioGroup == donationRadioGroup) {
                return selectedText.equals("Non");
            } else if (radioGroup == hivRadioGroup) {
                return selectedText.equals("Non");
            } else if (radioGroup == cancerRadioGroup) {
                return selectedText.equals("Non");
            } else if (radioGroup == chronicDiseaseRadioGroup) {
                return selectedText.equals("Non");
            } else if (radioGroup == chestPainRadioGroup) {
                return selectedText.equals("Non");
            } else if (radioGroup == transfusionRadioGroup) {
                return selectedText.equals("Non");
            } else if (radioGroup == drugsTattooRadioGroup) {
                return selectedText.equals("Non");
            } else if (radioGroup == anemiaRadioGroup) {
                return selectedText.equals("Non");
            } else if (radioGroup == surgeryRadioGroup) {
                return selectedText.equals("Non");
            } else if (radioGroup == feverRadioGroup) {
                return selectedText.equals("Non");
            } else if (radioGroup == dentalCareRadioGroup) {
                return selectedText.equals("Non");
            } else if (radioGroup == medicationRadioGroup) {
                return selectedText.equals("Non");
            }
        }
        return false; // Return false if no answer is selected
    }
}
