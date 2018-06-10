package com.adityadua.menuandroid28mdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String [] text = {"Item 1","Item 2","Item 3","Item 4","Item 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView)findViewById(R.id.tv1);

        registerForContextMenu(textView);

        ArrayAdapter<String> array = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,text);
        ListView listView = (ListView)findViewById(R.id.listView1);

        listView.setAdapter(array);
        registerForContextMenu(listView);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("My Context Menu");
        menu.setHeaderIcon(R.mipmap.ic_launcher);

        if(v.getId() == R.id.listView1){
            menu.add(0,106,1,"Select All");
        }

        /**
         * 1) Group Id
         * 2) Item ID of the Menu Item
         * 3) Sequence Number
         */
        menu.add(0,100,1,"Cut");
        menu.add(0,101,2,"Copy");
        menu.add(0,103,5,"Copy as Text");
        menu.add(0,102,3,"Paste");
        menu.add(0,104,4,"Delete");





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        switch (item.getItemId()){
            case R.id.settingMenuOption :
                Toast.makeText(this, "Setting Menu is Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profileMenuOption :
                Toast.makeText(this, "Profile Menu Option is Clicked", Toast.LENGTH_SHORT).show();
                        break;


        }
        return super.onOptionsItemSelected(item);
    }
}
