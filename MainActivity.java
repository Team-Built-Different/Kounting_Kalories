package com.example.practice3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button AddMealButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    { super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    AddMealButton = (Button) findViewById(R.id.AddMealButton);
    AddMealButton.setOnClickListener(new View.OnClickListener() {
        @Override

        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, AddMealActivity.class);
            startActivity(intent);
        }
    });

}}



