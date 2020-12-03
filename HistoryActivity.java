package com.example.kv1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Vector;

public class HistoryActivity extends AppCompatActivity {
    Vector<String> VecMeal = new Vector<String>();
    Vector<Integer> VecCalories= new Vector<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);





        ParseQuery<ParseObject> query = ParseQuery.getQuery("History");
        query.whereExists("Calories");
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject player, ParseException e) {
                if (e == null) {
                    String NameOfMeal = player.getString("NameOfMeal");
                    int Calories = player.getInt("Calories");
                    Log.d("info", String.valueOf(Calories));
                    Log.d("info",NameOfMeal);
                } else {
                    // Something is wrong
                }
            }
        });


    }
}