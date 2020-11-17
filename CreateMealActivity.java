package com.example.kountingkalories; //Author: Isaac Zavala

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateMealActivity extends AppCompatActivity {
    private Button save_food;// the button to save the food
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meal);
        save_food = (Button) findViewById(R.id.save_food);
        save_food.setOnClickListener(new View.OnClickListener() {       //This is where the program responds to the click of the button. 
            @Override
            public void onClick(View v) {  //this is the action that is taken when the button is clicked. 

            } // This is where we need to connect our database so we can create a place where the meals the user inputs are saved.
        });
    }
}
