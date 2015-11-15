package com.sarah.timejournal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.GregorianCalendar;

public class AddTimeslotActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner categorySpinner;
    ArrayAdapter<CharSequence> categoryAdapter;
    CharSequence currentCategory;
    int currentTimeslot = 1;
    GregorianCalendar currentDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_timeslot);


        Intent intent = getIntent();
        currentTimeslot = intent.getIntExtra(ChooseTimeslot.TIMESLOT, 0);
        //TODO: get Date from intent


        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        categoryAdapter = ArrayAdapter.createFromResource(this,
                R.array.categories_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        categorySpinner.setAdapter(categoryAdapter);
        categorySpinner.setOnItemSelectedListener(this);
    }

    public void sendTimeslot(View view) {
        EditText timeslotDesc = (EditText) findViewById(R.id.timeslotDesc);
        System.out.println("New Timeslot:");
        System.out.println(currentDay.toString());
        System.out.println(currentTimeslot);
        System.out.println(timeslotDesc.getText());
        System.out.println(currentCategory);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Object item = parent.getItemAtPosition(pos);
        currentCategory = item.toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // do nothing
    }
}
