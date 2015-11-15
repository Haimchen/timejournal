package com.sarah.timejournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ChooseTimeslot extends AppCompatActivity {

    public static final String TIMESLOT = "com.sarah.timejournal.TIMESLOT";
    public static final String CURRENT_DAY = "com.sarah.timejournal.CURRENT_DAY";
    private ArrayAdapter<Integer> timeslotAdapter;
    private ArrayList<Integer> emptyTimeslots;
    private GregorianCalendar currentDay;
    private Integer choosenTimeslot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_timeslot);

        currentDay = new GregorianCalendar();

        emptyTimeslots = findEmptyTimeslots();
        timeslotAdapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_list_item_1, emptyTimeslots);

        ListView timeslotList = (ListView) findViewById(R.id.timeslotList);

        timeslotAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeslotList.setAdapter(timeslotAdapter);

        // timeslotList.setOnItemSelectedListener(this);


        timeslotList.setOnItemClickListener(mMessageClickedHandler);
    }

    private ArrayList<Integer> findEmptyTimeslots() {
        ArrayList<Integer> list = new ArrayList<>();

        // TODO: implement method
        // get all empty timeslots from database for currentDay
        // sort most current slot first

        list.add(1);
        list.add(5);

        return list;
    }

    public void addTimeslot() {

        Intent intent = new Intent(this, AddTimeslotActivity.class);
        intent.putExtra(TIMESLOT, choosenTimeslot);
        intent.putExtra(CURRENT_DAY, currentDay);
        // TODO: add other parameters for AddTimeslot ?

        startActivity(intent);
    }

    // Create a message handling object as an anonymous class.
    private AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            // Do something in response to the click
            choosenTimeslot = (Integer) parent.getItemAtPosition(position);

            addTimeslot();
        }
    };
}

