//this class is done by Eric Gonzalez. this is the class for the activity_new_meal.xml file variables are string Mealname and int Calories.
package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;


public class NewMealActivity extends AppCompatActivity {
    public static final String Calories_count ="com.example.myapplication.example.Calories_count";
    String Mealname;
    int Calories;

    EditText MealNameInput;
    EditText UserCaloriesInput;
    Button IncreaseCalorieCountButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meal);
        MealNameInput =(EditText) findViewById(R.id.MealNameInput);
        UserCaloriesInput  =(EditText) findViewById(R.id.UserCaloriesInput);
        IncreaseCalorieCountButton = (Button)findViewById(R.id.IncreaseCalorieCountButton);
        IncreaseCalorieCountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mealname = MealNameInput.getText().toString();
                Calories = Integer.valueOf(UserCaloriesInput.getText().toString());
                Intent intent = new Intent(NewMealActivity.this, MainActivity.class);
                intent.putExtra(Calories_count,Calories);
                startActivity(intent);

                // Configure Query
                ParseObject History = new ParseObject("History");
                // Store an object
                History.put("NameOfMeal", Mealname);
                History.put("Calories", Calories);


                // Saving object
                History.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            // Success
                        } else {
                            // Error
                        }
                    }
                });


            }
        });

    }
}
