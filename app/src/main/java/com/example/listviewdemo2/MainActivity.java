package com.example.listviewdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView listView ;
    ArrayList<String> coursesList;
    ArrayAdapter adapter;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // create an array of strings
        String[] courses = {"Javascript","Flutter","Web Development","Web Design","Python","Java"};
        // get reference to the ids for the views
        listView = findViewById(R.id.listview);

        // get EditText id
        editText = findViewById(R.id.new_course);



        // get the button id

        button = findViewById(R.id.btn_add_course);
        // populate the arraylist with the array elements using Arrays.asList() method
        coursesList = new ArrayList<>(Arrays.asList(courses));

        // set the array adapter xml file(i.e view ) to a predefined view provided by android
        // format is ArrayAdapter(context,xml_view_file,arraylist)
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,coursesList);

        // set the adapter for the listview to the one provided above

        listView.setAdapter(adapter);

        // create the click event for when button is clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String course_input = editText.getText().toString();

                    coursesList.add(course_input);
                    adapter.notifyDataSetChanged();

            }
        });
    }
}