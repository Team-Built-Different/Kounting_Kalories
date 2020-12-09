// This is the main for the project. This is the homescreen of the app and this is all the writtewn code. THis is not the XML for the GUI but the code of the fuctions in the main.
// This file was created by Alexander Sanchez

package com.example.kountingkalories;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseInstallation;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static int UpdateCalories;
    private static int updatetime;
    Button AddMealButton;
    Button CreateMealButton;
    Button MealOptionButton;
    Button HistoryButton;
    Button refresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ParseInstallation.getCurrentInstallation().saveInBackground();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddMealButton = (Button) findViewById(R.id.AddMealButton);
        CreateMealButton = (Button) findViewById(R.id.CreateMealButton);
        MealOptionButton = (Button) findViewById(R.id.MealOptionButton);
        HistoryButton = (Button) findViewById(R.id.HistoryButton);
        refresh = (Button) findViewById(R.id.refresh);
        Intent intent = getIntent();
        int NewCalories = intent.getIntExtra(NewMealActivity.Calories_count, 0);//this is from the other activity NewMealActivity
        TextView textView1 = (TextView) findViewById(R.id.CalorieCount);
        Log.d("info", String.valueOf(UpdateCalories));
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        if (updatetime == day) {
            UpdateCalories = UpdateCalories + NewCalories;

            updatetime = day;
        } else {
            updatetime = day;
            UpdateCalories = 0;
        }
            refresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);

                    startActivity(intent);

                }
            });

        textView1.setText("" + UpdateCalories);


        AddMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddMealActivity.class);
                startActivity(intent);
            }
        });
        CreateMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateMealActivity.class);
                startActivity(intent);
            }
        });
        HistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);
            }
        });
        MealOptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MealOptions.class);
                startActivity(intent);
            }
        });


    }
}

