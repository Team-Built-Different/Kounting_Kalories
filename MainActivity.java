public class MainActivity extends AppCompatActivity {

    Button AddMealButton;
    Button CreateMealButton;
    Button MealOptionButton;
    Button HistoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddMealButton = (Button)findViewById(R.id.AddMealButton);
        CreateMealButton = (Button)findViewById(R.id.CreateMealButton);
        MealOptionButton= (Button)findViewById(R.id.MealOptionButton);
        HistoryButton = (Button)findViewById(R.id.HistoryButton);
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

    }

}