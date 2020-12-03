
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

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
                Intent intent = new Intent(CreateMealActivity.this, MainActivity.class);
                startActivity(intent);


                ParseObject MealSaved = new ParseObject("MealSaved");
// Store an object
                MealSaved.put("NameOfMeal", Mealname);
                MealSaved.put("Calories", Calories);


// Saving object
                MealSaved.saveInBackground(new SaveCallback() {
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
