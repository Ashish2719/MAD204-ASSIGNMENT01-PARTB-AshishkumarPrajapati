/**
 * MAD 204 ASSIGNMENT 1 PART B
 * NAME - ASHISHKUMAR PRAJAPATI ID-A00194842
 * DATE - 04/10/25
 * SIMPLE SINGLE ACTIVITY APP: NAME , AGE PROGRAM AND SHOWS INTRODUCTION.
 */

// simple application by Ash.


package com.example.appbyashish; // THIS IS MY PROJECT PPACKAGE

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appbyashish.R;

public class MainActivity extends AppCompatActivity {
    EditText etName, etAge, etProgram;
    TextView tvOutput;
    Button btnIntroduce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etProgram = findViewById(R.id.etProgram);
        tvOutput = findViewById(R.id.tvOutput);
        btnIntroduce = findViewById(R.id.btnIntroduce);

        btnIntroduce.setOnClickListener(this::onClick);
    }

    private void onClick(View v) {
        String name = etName.getText().toString().trim();
        String ageStr = etAge.getText().toString().trim();
        String program = etProgram.getText().toString().trim();

        if (name.isEmpty() || ageStr.isEmpty() || program.isEmpty()) {
            tvOutput.setText("Please fill in all fields.");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageStr);
            if (age <= 0) {
                tvOutput.setText("Age must be greater than zero.");
                return;
            }
        } catch (NumberFormatException ex) {
            tvOutput.setText("Please enter a valid numeric age.");
            return;
        }

        String Showmessege = String.format("Hi, I'm %s, %d years old, studying %s.", name, age, program);
        tvOutput.setText(Showmessege);
    }
}


