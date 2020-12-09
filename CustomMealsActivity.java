package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomMealsActivity extends AppCompatActivity {
    public ArrayList<String> dataList = new ArrayList<String>();
    public String[] myArray = {};


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_meals);
        findObjects();
    }

    private void findObjects() {
        myArray = new String[]{};
        final ListView listView = (ListView) findViewById(R.id.listviewA);

        // Configure Query
        ParseQuery<ParseObject> query = ParseQuery.getQuery("MealSaved");

        // Query Parameters
        query.whereExists("Calories");

        // Sorts the results in ascending order by the itemName field
        query.orderByAscending("Calories");

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, final ParseException e) {
                if (e == null) {
                    // Adding objects into the Array
                    for (int i = 0; i < objects.size(); i++) {
                        String element = objects.get(i).getString("NameOfMeal");

                        dataList.add(element.toString());
                    }
                } else {

                }
                myArray = dataList.toArray(new String[dataList.size()]);

                final ArrayList<String> list = new ArrayList<String>(Arrays.asList(myArray));

                ArrayAdapter<String> adapterList
                        = new ArrayAdapter<String>(CustomMealsActivity.this, android.R.layout.simple_list_item_single_choice, myArray);

                listView.setAdapter(adapterList);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(final AdapterView<?> adapter, View v, final int position, long id) {

                        final String value = (String) adapter.getItemAtPosition(position);

                        //put in code for adding it to the history and adding it to calorie count


                    }

                });
            }
        });
    }
}