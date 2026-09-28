package com.ananya.basiccalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import javax.xml.transform.Result;

import kotlin.Suppress;

public class MainActivity extends AppCompatActivity {

    // 1. Create Objects
    EditText num1, num2;
    Button BtnAdd, BtnSub, BtnMult, BtnDiv;
    TextView result;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 2. Bind UI with Java
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        BtnAdd = findViewById(R.id.BtnAdd);
        BtnSub = findViewById(R.id.BtnSub);
        BtnMult = findViewById(R.id.BtnMult);
        BtnDiv = findViewById(R.id.BtnDiv);

        result = findViewById(R.id.result);

        // Button Click Listeners
        BtnAdd.setOnClickListener(v -> calculate("+"));
        BtnSub.setOnClickListener(v -> calculate("-"));
        BtnMult.setOnClickListener(v -> calculate("*"));
        BtnDiv.setOnClickListener(v -> calculate("/"));

    }

    @SuppressLint("SetTextI18n")
    private void calculate(String operation) {
        String first = num1.getText().toString().trim();
        String second = num2.getText().toString().trim();

        if (first.isEmpty() || second.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double Num1 = Double.parseDouble(first);
        double Num2 = Double.parseDouble(second);
        double answer = 0;

        switch (operation) {
            case "+":
                answer = Num1 + Num2;
                break;

            case "-":
                answer = Num1 - Num2;
                break;

            case "*":
                answer = Num1 * Num2;
                break;

            case "/":
                if (Num2 == 0) {
                    Toast.makeText(this, "Cannot divide by 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                answer = Num1 / Num2;
                break;
        }
        result.setText("" + answer);
    }
}