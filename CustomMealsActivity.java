// written by:Eric Gonzalez
// tested by:Eric Gonzalez
// debugged by:Eric Gonzalez
// etc.back end for the ability to increase calorie count using saved meals.

package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomMealsActivity extends AppCompatActivity {
    public static final String Calories_count ="com.example.myapplication.example.Calories_count";
    public ArrayList<String> dataList = new ArrayList<String>();
    public String[] myArray = {};
    public String MealName;
     int Calories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_meals);
        findObjects();
    }
    
    private void findObjects() {
        myArray = new String[]{};
        final ListView listView = (ListView) findViewById(R.id.listviewA);

        // Configure Query searches for MealSaved on the database
        ParseQuery<ParseObject> query = ParseQuery.getQuery("MealSaved");

        // Query Parameters list all hte meals which contain calories
        query.whereExists("Calories");

        // Sorts the results in ascending order by the calories
        query.orderByAscending("Calories");

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, final ParseException e) {
                if (e == null) {
                    // Adding objects into the Array
                    for (int i = 0; i < objects.size(); i++) {
                        String element = objects.get(i).getString("NameOfMeal");

                        dataList.add(element.toString());//puts the name of the meals into the arraylist 
                    }
                } else {

                }
                myArray = dataList.toArray(new String[dataList.size()]);//converts arraylist to an array

                final ArrayList<String> list = new ArrayList<String>(Arrays.asList(myArray));

                ArrayAdapter<String> adapterList
                        = new ArrayAdapter<String>(CustomMealsActivity.this, android.R.layout.simple_list_item_single_choice, myArray);// uses adapter to be able to put the array into list view

                listView.setAdapter(adapterList);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(final AdapterView<?> adapter, View v, final int position, long id) {//reads when the user click on a meal

                        final String value = (String) adapter.getItemAtPosition(position);

                        ParseQuery<ParseObject> query = ParseQuery.getQuery("MealSaved");//searches the data base in MealSaved for the meal which has the same name as the meal clicked on
                        query.whereEqualTo("NameOfMeal", value);
                        query.getFirstInBackground(new GetCallback<ParseObject>() {
                            public void done(ParseObject player, ParseException e) {
                                if (e == null) {
                                     MealName = player.getString("NameOfMeal");
                                    Calories = player.getInt("Calories");//gets calories and meal name

                                } else {
                                    // Something is wrong
                                }
                                //send calories to main to increase calorie count
                                Intent intent = new Intent(CustomMealsActivity.this, MainActivity.class);
                                intent.putExtra(Calories_count,Calories);
                                startActivity(intent);

                                // Configure Query
                                ParseObject History = new ParseObject("History");//adds meal and calories to the history in database
                                // Store an object
                                History.put("NameOfMeal", MealName);
                                History.put("Calories", Calories);


                                // Saving object to database
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

                });
            }
        });
    }
}
