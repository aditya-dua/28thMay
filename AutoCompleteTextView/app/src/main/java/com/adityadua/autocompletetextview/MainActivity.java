package com.adityadua.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class MainActivity extends AppCompatActivity {

    String [] colors ={
            "Red","Black","Blue","Brown","Purple"
    };

    AutoCompleteTextView atc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,colors);

        atc = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        atc.setAdapter(arrayAdapter);

    }
}
