package com.adityadua.listviewdemo28m;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String [] countryArr={
            "India",
            "Japan",
            "Canada",
            "KSA",
            "Nepal",
            "Sri Lanka",
            "Pakistan",
            "United States Of Amreica"

    };
    ArrayAdapter<String> countryAdapter;

    String [] indiaStateSpinner = {"Delhi","Haryana","Uttar Pradesh","Gujarat"};
    Spinner stateSpinner;
    ArrayAdapter<String> stateArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.countrylistView);

        countryAdapter = new ArrayAdapter<String>(
                getApplicationContext(),android.R.layout.simple_list_item_1,countryArr);

        listView.setAdapter(countryAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int i, long l) {
                //1 Which Adapetr is clicked :

                //2 if you want to check on listview :
                // you will use this param : view

                //3 Position : which element is clicked :: int i

                //4 Row Id which is clicked

                Toast.makeText(MainActivity.this, "Country Selected Is :"
                        +countryArr[i], Toast.LENGTH_SHORT).show();
            }
        });

        stateSpinner = (Spinner)findViewById(R.id.StateSpinner);
        stateArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item,indiaStateSpinner);

        stateSpinner.setAdapter(stateArrayAdapter);

        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView,
                                       View view, int i, long l) {
                Toast.makeText(MainActivity.this, "State Selected Is:"+
                        indiaStateSpinner[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
