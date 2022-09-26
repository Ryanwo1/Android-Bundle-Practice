package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Page1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        Button nextToPageThreeBtn;
        nextToPageThreeBtn = findViewById(R.id.nextToPage2Btn);

        RadioGroup ageRangeRadioGroup;
        ageRangeRadioGroup = findViewById(R.id.ageRangeRadioGroup);


        InputStream inputStream = getBaseContext().getResources().openRawResource(R.raw.countries);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        ArrayList<String> countryNamesArrayList = new ArrayList<>();
        Spinner countrySpinner = findViewById(R.id.countrySpinner);

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(Page1.this,
                android.R.layout.simple_spinner_dropdown_item, countryNamesArrayList);

        countrySpinner.setAdapter(countryAdapter);

        String line;
        try {
            line = bufferedReader.readLine();
            while (line != null) {
                countryNamesArrayList.add(line);
                countryAdapter.notifyDataSetChanged();
                line = bufferedReader.readLine();

            }
            bufferedReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        nextToPageThreeBtn.setOnClickListener(v -> {
            String countryChosen = countrySpinner.getSelectedItem().toString();

           int radioID = ageRangeRadioGroup.getCheckedRadioButtonId();
           Button radioButton = findViewById(radioID);
           String ageRangeChosenText = radioButton.getText().toString();

            Intent intent = new Intent(this, Page2.class);
            intent.putExtra("Page1RadioText", ageRangeChosenText);
            intent.putExtra("chosenCountry", countryChosen);
            startActivity(intent);
        });

        }
}