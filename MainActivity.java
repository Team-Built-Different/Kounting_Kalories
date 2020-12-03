// This is the main for the project. This is the homescreen of the app and this is all the writtewn code. THis is not the XML for the GUI but the code of the fuctions in the main.
// This file was created by Alexander Sanchez

package com.example.kountingkalories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseInstallation;

public class MainActivity extends AppCompatActivity {

    Button AddMealButton;
    Button CreateMealButton;
    Button MealOptionButton;
    Button HistoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ParseInstallation.getCurrentInstallation().saveInBackground();

        int OldCalories =0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddMealButton = (Button)findViewById(R.id.AddMealButton);
        CreateMealButton = (Button)findViewById(R.id.CreateMealButton);
        MealOptionButton= (Button)findViewById(R.id.MealOptionButton);
        HistoryButton = (Button)findViewById(R.id.HistoryButton);


        Intent intent =getIntent();
        int NewCalories =intent.getIntExtra(NewMealActivity.Calories_count,0);//this is from the other activity NewMealActivity
        TextView textView1 =(TextView) findViewById(R.id.CalorieCount);
        textView1.setText(""+NewCalories);
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




    }

}
