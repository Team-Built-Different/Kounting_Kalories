// This file was made by Jorge Rios
package com.example.kv1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;
import java.util.Vector;

public class HistoryActivity extends AppCompatActivity {
    Vector<String> VecMeal = new Vector<String>();
    Vector<Integer> VecCalories= new Vector<Integer>();
    //public ArrayList<String> NameOfMeal= new ArrayList<String>();
   /// public ArrayList<int> Calories = new ArrayList<int>();
    public String[] myArray = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);




        // Configure Query
        ParseQuery<ParseObject> query = ParseQuery.getQuery("History");

        // Query Parameters
        query.whereExists("Calories");

        // Sorts the results in ascending order by the itemName field
        query.orderByAscending("Calories");

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, final ParseException e) {
                if (e == null){
                    // Adding objects into the Array
                    for(int i= 0 ; i < objects.size(); i++){
                        String element = objects.get(i).getString("NameOfMeal");
                        int temp = objects.get(i).getInt("Calories");

                        VecMeal.add(element.toString());
                        VecCalories.add(temp);
                        Log.d("info", String.valueOf(VecMeal));
                        Log.d("info", String.valueOf(VecCalories));
                    }
                } else {

                }
               // myArray = dataList.toArray(new String[dataList.size()]);


    }
});
    }
}
