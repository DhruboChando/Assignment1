package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Button btnNumber1, btnNumber2, btnNumber3, btnNumber4, btnNumber5, btnNumber6, btnNumber7;
    private Toast toast;
    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        btnNumber1 = findViewById(R.id.btnNumber1);
        btnNumber2 = findViewById(R.id.btnNumber2);
        btnNumber3 = findViewById(R.id.btnNumber3);
        btnNumber4 = findViewById(R.id.btnNumber4);
        btnNumber5 = findViewById(R.id.btnNumber5);
        btnNumber6 = findViewById(R.id.btnNumber6);
        btnNumber7 = findViewById(R.id.btnNumber7);

        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_layout));
        toast = new Toast(getApplicationContext()); //Creating the Toast object
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(layout);//setting the view of custom toast layout

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                int number = Integer.parseInt(button.getText().toString());
                checkLuckyNumber(number);
            }
        };

        btnNumber1.setOnClickListener(listener);
        btnNumber2.setOnClickListener(listener);
        btnNumber3.setOnClickListener(listener);
        btnNumber4.setOnClickListener(listener);
        btnNumber5.setOnClickListener(listener);
        btnNumber6.setOnClickListener(listener);
        btnNumber7.setOnClickListener(listener);
    }

    @SuppressLint("SetTextI18n")
    private void checkLuckyNumber(int number) {
        if (number % 7 == 0) {
            toast.show();
        } else {
            Toast.makeText(MainActivity.this, "Sorry!\nBetter Luck next time .", Toast.LENGTH_LONG).
                    show();

            tvResult.setVisibility(View.VISIBLE);
        }
    }
}
