package com.example.assignment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    Toast toast;
    Button enter;
    EditText number_box;
    int lucky_number = 1001;
    String input_number;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv_hello);
        number_box = findViewById(R.id.et_name);
        enter = findViewById(R.id.btn_enter);

        LayoutInflater li = getLayoutInflater(); //Creating the LayoutInflater instance
        //Getting the View object as defined in the customtoast.xml file
        View layout = li.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_layout));
        toast = new Toast(getApplicationContext()); //Creating the Toast object
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(layout);//setting the view of custom toast layout

        Intent intent = getIntent();
        String name1 = intent.getStringExtra("name");

        tv1.setText("Hello " + name1 + "!\nReady to test your luck!!! Ha..ah\nEnter your Lucky number ");

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_number = number_box.getText().toString().trim();

                if(!input_number.isEmpty() && input_number.equals(lucky_number)){
                    number_box.setText("");
                    toast.show();
                }

            }
        });

    }

}