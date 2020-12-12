# Kounting_Kalories 
AddMealActivity.java
- This is the class for adding a meal which is the back end for the buttons of new meal and custom meal.
AndroidManifest.xml
-This was pre built code that we had to add information into so that we could connect our app to the database and save all the information that is taken from each function.

App.java
-This is were the connection to the database occurs.

CreateMealActivity.java
- This is the class for the create neal function which activates the button that puts the meal in the meals saved databse but does not increase the calorie count nor access the history database. 
CustomMealsActivity.java
  -back end for the ability to increase calorie count using saved meals.
HistoryActivity.java
-  This is where the user is shown meals that have been previously consumed.
MainActivity.java
- This is the main class of the project and it connects to all other classes/functions of the code. It also contains the counter.

MealFile.txt
  -This was our original plan to use a text file of preloaded data but this will now move to the database not really necessary but it was a reference 
MealOptions.java
   -This is the class for the meal options function of our project where it suggests meals based on the remaning calorie count you have that is less than the total amount we set which is 2000 calories. 
NewMealActivity.java
  -this is the class for the activity_new_meal.xml file variables are string Mealname and int Calories. stores the meal name and calories to the database

activity_add_meal.xml
  -This file handles the GUI for the AddMealActivity.java class. The two buttons on this xml file are custom meal and new meal.
activity_create_meal.xml
  - This is the xml for the GUI for the Create Meal.java class. It has two edit text boxes one for meal name and the other for calorie amount. Then one button to store the info into the database.
activity_custom_meal.xml
- This the GUI for the custom meals screen. 

activity_history.xml
- This is the GUI for the history screen.

activity_main.xml
- This is the GUI for the home screen.

activity_meal_option.xml
-This is the GUI for the meal optionsn screen. Its vew is set as a list

activity_new_meal.xml
-This xml file is the GUI for the NewMealActivity.java. this file contrains the buttons two inputs which are meal names,
meal calories, and a submit buttom. 

strings.xml


https://github.com/Team-Built-Different/Kounting_Kalories
Our project was made on Android Studio so you're going to need that.
You will either need an android device or a computer that can run an android device emulator.
You will also have to have some knowledge of Java. 

Link to Android Studio Donwload 
https://developer.android.com/studio
