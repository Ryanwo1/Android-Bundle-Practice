package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import java.util.ArrayList;


public class Page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        CompoundButton businessCheckbox;
        CompoundButton relaxationCheckbox;
        CompoundButton medicalCheckbox;
        CompoundButton familyCheckbox;
        CompoundButton othersCheckbox;

        RatingBar ratingStarBar;

        Button nextButton;

        businessCheckbox = findViewById(R.id.businessCheckBox);
        relaxationCheckbox = findViewById(R.id.relaxationCheckBox);
        medicalCheckbox = findViewById(R.id.checkboxMedical);
        familyCheckbox = findViewById(R.id.checkboxFamily);
        othersCheckbox = findViewById(R.id.checkboxOther);
        ArrayList<String> arrayListOfCheckboxes = new ArrayList<>();

        ratingStarBar = findViewById(R.id.ratingBar);
        nextButton = findViewById(R.id.nextToPage3Btn);

        businessCheckbox.setOnClickListener(v -> {
            if (businessCheckbox.isChecked()) {
                arrayListOfCheckboxes.add(businessCheckbox.getText().toString());
            } else {
                arrayListOfCheckboxes.remove(businessCheckbox.getText().toString());
            }
        });

        relaxationCheckbox.setOnClickListener(v -> {
            if (relaxationCheckbox.isChecked()) {
                arrayListOfCheckboxes.add(relaxationCheckbox.getText().toString());
            } else {
                arrayListOfCheckboxes.remove(relaxationCheckbox.getText().toString());
            }
        });

        medicalCheckbox.setOnClickListener(v -> {
            if (medicalCheckbox.isChecked()) {
                arrayListOfCheckboxes.add(medicalCheckbox.getText().toString());
            } else {
                arrayListOfCheckboxes.remove(medicalCheckbox.getText().toString());
            }
        });

        familyCheckbox.setOnClickListener(v -> {
            if (familyCheckbox.isChecked()) {
                arrayListOfCheckboxes.add(familyCheckbox.getText().toString());
            } else {
                arrayListOfCheckboxes.remove(familyCheckbox.getText().toString());
            }
        });

        othersCheckbox.setOnClickListener(v -> {
            if (othersCheckbox.isChecked()) {
                arrayListOfCheckboxes.add(othersCheckbox.getText().toString());
            } else {
                arrayListOfCheckboxes.remove(othersCheckbox.getText().toString());
            }
        });




        nextButton.setOnClickListener(v -> {

            Bundle extras = getIntent().getExtras();
            Intent intent = new Intent(this, Page3.class);

            if (extras != null) {
                String ageRangeChosenText = extras.getString("Page1RadioText");
                String countryChosen = extras.getString("chosenCountry");
                intent.putExtra("Page1RadioText", ageRangeChosenText);
                intent.putExtra("chosenCountry", countryChosen);
            }
            intent.putStringArrayListExtra("arrayListOfCheckboxes", arrayListOfCheckboxes);
            intent.putExtra("ratingBar", String.valueOf(ratingStarBar.getRating()));
            startActivity(intent);
        });


    }
}