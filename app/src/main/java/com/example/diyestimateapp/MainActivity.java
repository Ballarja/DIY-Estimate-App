package com.example.diyestimateapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView txtMemory, txtResult;
    private Button btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnAC, btnC, btnPercent;
    private ImageButton button_send;

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
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnAC = findViewById(R.id.btnAC);
        btnC = findViewById(R.id.btnC);
        btnPercent = findViewById(R.id.btnPercent);

        // Initialize button_send
        button_send = findViewById(R.id.button_send);

        // Set onClickListeners for numbers and operators
        setNumberListeners();
        setOperatorListeners();

        // Set OnClickListener for button_send to show a Toast
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Send button clicked!", Toast.LENGTH_SHORT).show();
            }
        });
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

        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);
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

        btnPercent.setOnClickListener(listener);

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