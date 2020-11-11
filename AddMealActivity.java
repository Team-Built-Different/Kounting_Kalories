package com.example.kv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class AddMealActivity extends AppCompatActivity {
    Button NewMealButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);
        NewMealButton = (Button)findViewById(R.id.NewMealButton);
        NewMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddMealActivity.this, NewMealActivity.class);
                startActivity(intent);
            }
        });

    }
}