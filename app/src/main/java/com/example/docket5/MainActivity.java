package com.example.docket5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Random;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText course;
    private EditText task;
    private EditText startDate;
    private EditText endDate;
    private Button btn;
    private ListView itemList;
    Random rng = new Random();

    private Note note;
    String itemEntered = "";

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        course = findViewById(R.id.course);
        task = findViewById(R.id.task);
        startDate = findViewById(R.id.start_date);
        endDate = findViewById(R.id.end_date);

        btn = findViewById(R.id.add_btn);
        itemList = findViewById(R.id.items_list);

        items = FileHelper.readData(this);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        itemList.setAdapter(adapter);

        btn.setOnClickListener(this);
        itemList.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.add_btn:
                note = new Note(""+course.getText().toString(),
                        ""+task.getText().toString(),
                        ""+startDate.getText().toString(),
                        ""+endDate.getText().toString());
                itemEntered = note.getNote();
                adapter.add(itemEntered);
                course.setText("");
                task.setText("");
                startDate.setText("");
                endDate.setText("");
                FileHelper.writeData(items, this);
                Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();
                int i = rng.nextInt(3);
                if(i == 0){
                    Toast.makeText(this,
                            "Corny Joke: What do you call it when Batman skips church?",
                            Toast.LENGTH_LONG).show();
                    Toast.makeText(this, "Christian Bale!", Toast.LENGTH_LONG).show();
                }else if(i == 1){
                    Toast.makeText(this,
                            "Corny Joke: What do you call a group of unorganized cats?",
                            Toast.LENGTH_LONG).show();
                    Toast.makeText(this,
                            "A Cat-Astrophe!", Toast.LENGTH_LONG).show();
                }else if(i == 2){
                    Toast.makeText(this,
                            "Corny Joke: Why don't they play poker in the jungle?",
                            Toast.LENGTH_LONG).show();
                    Toast.makeText(this,
                            "Too Many Cheetahs!", Toast.LENGTH_LONG).show();
                }else if(i == 3) {
                    Toast.makeText(this,
                            "Corny Joke: Why did the stadium get hot after the game?",
                            Toast.LENGTH_LONG).show();
                    Toast.makeText(this,
                            "All of the Fans Left!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,
                            "Corny Joke: 8. What do you call the Children of the Corn's father?",
                            Toast.LENGTH_LONG).show();
                    Toast.makeText(this,
                            "POP Corn", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        FileHelper.writeData(items, this);
        Toast.makeText(this, "Item Deleted", Toast.LENGTH_SHORT).show();
        int x = rng.nextInt(1);
        if(x == 0) {
            Toast.makeText(this, "I sure hope you aren't slacking! Don't forget " +
                            "I am always watching you :)",
                    Toast.LENGTH_LONG).show();
        }
    }
}
