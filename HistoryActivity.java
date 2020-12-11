// written by:Jorge Rios
// tested by: Jorge Rios
// debugged by: Jorge Rios
package com.example.kv1;

import android.os.Bundle;
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

public class HistoryActivity extends AppCompatActivity {
    public ArrayList<String> dataList = new ArrayList<String>();
    public String[] myArray = {};




   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_history);
       findObjects();
   }

       private void findObjects(){
           myArray = new String[]{};
           final ListView listView = (ListView) findViewById(R.id.listviewA);

           // Configure Query
           ParseQuery<ParseObject> query = ParseQuery.getQuery("History");

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

                   ArrayAdapter<String> adapterList = new ArrayAdapter<String>(HistoryActivity.this, android.R.layout.simple_list_item_single_choice, myArray);


                   listView.setAdapter(adapterList);

               }});}



}
