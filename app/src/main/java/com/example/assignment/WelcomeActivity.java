package com.example.assignment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity {
    Button btn1;
    EditText name_box;
    String name1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        name_box = findViewById(R.id.et_name);
        btn1 = findViewById(R.id.btn_enter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name1 = name_box.getText().toString().trim();

                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                intent.putExtra("name", name1); // Passing data
                startActivity(intent);
                finish();

            }
        });

    }
}