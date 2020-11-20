package com.example.kountingkalories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateMealActivity extends AppCompatActivity {
    String Mealname;
    int Calories;
    Button save_food;
    EditText edit_cal;
    EditText edit_meal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meal);
        edit_meal =(EditText) findViewById(R.id.edit_meal);
        edit_cal  =(EditText) findViewById(R.id.edit_cal);
        save_food = (Button)findViewById(R.id.save_food);
        save_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mealname = edit_meal.getText().toString();
                Calories = Integer.valueOf(edit_cal.getText().toString());
                Log.d("info",Mealname);
                Log.d("info", String.valueOf(Calories));



            }
        });


    }
}
