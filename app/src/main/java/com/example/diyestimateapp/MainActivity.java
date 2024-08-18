package com.example.diyestimateapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView txtMemory, txtResult;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnAdd, btnSub, btnMulti, btnDiv, btnDecimal, btnEqual;
    private Button btnAC, btnC, btnPercent;

    private String input = "";
    private String operator = "";
    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize TextViews
        txtMemory = findViewById(R.id.txtMemory);
        txtResult = findViewById(R.id.txtResult);

        // Initialize Buttons
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMulti = findViewById(R.id.btnMulti);
        btnDiv = findViewById(R.id.btnDiv);
        btnDecimal = findViewById(R.id.btnDecimal);
        btnEqual = findViewById(R.id.btnEqual);

        btnAC = findViewById(R.id.btnAC);
        btnC = findViewById(R.id.btnC);
        btnPercent = findViewById(R.id.btnPercent);

        // Set onClickListeners
        setNumberListeners();
        setOperatorListeners();
    }

    private void setNumberListeners() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                input += button.getText().toString();
                txtResult.setText(input);
            }
        };

        btn0.setOnClickListener(listener);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);
        btnDecimal.setOnClickListener(listener);
    }

    private void setOperatorListeners() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                operator = button.getText().toString();
                txtMemory.setText(input + " " + operator);
                result = input;
                input = "";
            }
        };

        btnAdd.setOnClickListener(listener);
        btnSub.setOnClickListener(listener);
        btnMulti.setOnClickListener(listener);
        btnDiv.setOnClickListener(listener);
        btnPercent.setOnClickListener(listener);

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearAll();
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearInput();
            }
        });
    }

    private void calculateResult() {
        double res = 0.0;
        double num1 = Double.parseDouble(result);
        double num2 = Double.parseDouble(input);

        switch (operator) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "X":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
            case "%":
                res = num1 % num2;
                break;
        }

        txtResult.setText(String.valueOf(res));
        txtMemory.setText(result + " " + operator + " " + input + " =");
        input = String.valueOf(res);
    }

    private void clearAll() {
        input = "";
        operator = "";
        result = "";
        txtMemory.setText("");
        txtResult.setText("0");
    }

    private void clearInput() {
        input = "";
        txtResult.setText("0");
    }
}