package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startPageOneBtn;
        startPageOneBtn = findViewById(R.id.startPage1Btn);

        EditText userEnteredCodeField;
        userEnteredCodeField = findViewById(R.id.editTextEnterCode);

        startPageOneBtn.setOnClickListener(v -> {
            String userCode = userEnteredCodeField.getText().toString();

            if (userCode.equals("COMP3717")) {
            Intent intent = new Intent(this, Page1.class);
            startActivity(intent);
                 } else {
                Toast.makeText(MainActivity.this, "WRONG CODE", Toast.LENGTH_LONG).show();
            //  toast informing them they're wrong
              }
        });

    }
}