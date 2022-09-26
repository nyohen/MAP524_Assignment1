package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;

public class MainActivity extends AppCompatActivity
{
    private final Calculator calculator = new Calculator();
    TextView typeTV;
    TextView resultTV;
    Button  n1, n2, n3, operAdd,
            n4, n5, n6, operSubtract,
            n7, n8, n9, operMultiply,
            btnClear, n0, operEqual, operDivide, btnNext;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeTV = findViewById(R.id.workingsTextView);
        resultTV = findViewById(R.id.resultTextView);

        n1 = findViewById(R.id.number1);
        n1.setOnClickListener(v -> {
            calculator.push("1");
            typeTV.append("1");
        });

        n2 = findViewById(R.id.number2);
        n2.setOnClickListener(v -> {
            calculator.push("2");
            typeTV.append("2");
        });

        n3 = findViewById(R.id.number3);
        n3.setOnClickListener(v -> {
            calculator.push("3");
            typeTV.append("3");
        });

        operAdd = findViewById(R.id.operatorAdd);
        operAdd.setOnClickListener(v -> {
            calculator.push("+");
            typeTV.append("+");
        });

        n4 = findViewById(R.id.number4);
        n4.setOnClickListener(v -> {
            calculator.push("4");
            typeTV.append("4");
        });


        n5 = findViewById(R.id.number5);
        n5.setOnClickListener(v -> {
            calculator.push("5");
            typeTV.append("5");
        });

        n6 = findViewById(R.id.number6);
        n6.setOnClickListener(v -> {
            calculator.push("6");
            typeTV.append("6");
        });

        operSubtract = findViewById(R.id.operatorSubtract);
        operSubtract.setOnClickListener(v -> {
            calculator.push("-");
            typeTV.append("-");
        });

        n7 = findViewById(R.id.number7);
        n7.setOnClickListener(v -> {
            calculator.push("7");
            typeTV.append("7");
        });

        n8 = findViewById(R.id.number8);
        n8.setOnClickListener(v -> {
            calculator.push("8");
            typeTV.append("8");
        });

        n9 = findViewById(R.id.number9);
        n9.setOnClickListener(v -> {
            calculator.push("9");
            typeTV.append("9");
        });

        operMultiply = findViewById(R.id.operatorMultiply);
        operMultiply.setOnClickListener(v -> {
            calculator.push("*");
            typeTV.append("*");
        });

        btnClear = findViewById(R.id.functionClear);
        btnClear.setOnClickListener(v -> {
            calculator.clear();
            typeTV.setText("");
        });

        n0 = findViewById(R.id.number0);
        n0.setOnClickListener(v -> {
            calculator.push("0");
            typeTV.append("0");
        });

        operEqual = findViewById(R.id.operatorEqual);
        operEqual.setOnClickListener(v -> {
            String result = calculator.calculate();

            if (!Objects.equals(result, "failed")) {
                typeTV.append("=" + result);
                if (btnNext
                        .getText()
                        .toString()
                        .equals("STANDARD - NO HISTORY")) {
                    resultTV.append(typeTV.getText().toString() + "\n");
                }
            } else {
                typeTV.append("= Not an Operator");
            }
        });

        operDivide = findViewById(R.id.operatorDivide);
        operDivide.setOnClickListener(temp -> {
            calculator.push("/");
            typeTV.append("/");
        });

        btnNext = findViewById(R.id.nextFragbutton);
        btnNext.setOnClickListener(v -> {
            if (btnNext
                    .getText()
                    .toString()
                    .equals("ADVANCED - WITH HISTORY")) {
                btnNext.setText("STANDARD - NO HISTORY");
            } else {
                btnNext.setText("ADVANCED - WITH HISTORY");
                resultTV.setText("");
            }
        });
    }
}