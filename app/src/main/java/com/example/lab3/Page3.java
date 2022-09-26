package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class Page3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        TextView countrySummaryText = findViewById(R.id.countrySummaryText);
        TextView ageRangeSummaryText = findViewById(R.id.ageRangeSummaryText);
        TextView travelPurposeSummaryText = findViewById(R.id.travelPurposeSummary);
        TextView travelRatingSummaryText = findViewById(R.id.travelRatingText);

        Button submitButton;
        submitButton = findViewById(R.id.submitBtn);
        submitButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, Page4.class);
            startActivity(intent);
        });

        Bundle extras = getIntent().getExtras();
        ArrayList<String> reasonsChecked = extras.getStringArrayList("arrayListOfCheckboxes");
        String travelPurposeAreaText = "";
        StringBuilder sb = new StringBuilder();

        for (String checkedBoxText : reasonsChecked) {
            travelPurposeAreaText = sb.append(checkedBoxText).toString();
            travelPurposeAreaText = sb.append("\n").toString();

       }

        countrySummaryText.setText("Country:\n" + extras.getString("chosenCountry"));
        ageRangeSummaryText.setText("Age Range:\n" + extras.getString("Page1RadioText"));

        if (travelPurposeAreaText.equals("null")) {
            travelPurposeAreaText = "No reasons were selected";
        }

        travelPurposeSummaryText.setText("Most Recent Travel Purpose:\n" + travelPurposeAreaText);
        travelRatingSummaryText.setText("Most Recent Travel Rating:\n" + extras.getString("ratingBar"));

    }
}