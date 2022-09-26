package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class Page4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        TextView thankYouText;

        thankYouText = findViewById(R.id.thankYouText);
        thankYouText.setTextColor(Color.RED);
    }
}