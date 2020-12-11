// written by:Jorge Rios
// tested by: Jorge Rios
// debugged by: Jorge Rios
package com.example.kv1;
// These are the packages that are required for the application to run
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AddMealActivity extends AppCompatActivity {
    Button NewMealButton;
    Button CustomMealsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);
        CustomMealsButton = (Button)findViewById(R.id.CustomMealsButton);
        NewMealButton = (Button)findViewById(R.id.NewMealButton);
        NewMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddMealActivity.this, NewMealActivity.class);
                startActivity(intent);
            }
        });

        CustomMealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddMealActivity.this, CustomMealsActivity.class);
                startActivity(intent);
            }
        });

    }
}
