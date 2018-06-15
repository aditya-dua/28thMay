package com.adityadua.databasesqlite28mdemo;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.adityadua.databasesqlite28mdemo.database.DBHelper;
import com.adityadua.databasesqlite28mdemo.utils.Constants;

public class MainActivity extends AppCompatActivity {

    String [] book_name={"My Experiments With Truth",
            "The Monk who sold his Ferrari",
            "Ctrl+F5",
            "The Wings OF Fire",
            "Stay Hungry,Stay Foolish"};

    String [] book_author_name={"M.K.Gandhi",
            "Robin Sharma",
            "Satya Nadella",
            "Dr A P J Abdul Kalam",
            "Rashmi Bansal"};

    String [] book_id={"324324ASAS",
                       "23424234FG",
                       "242535435R",
            "2442353FDG",
            "4534354335"};


    DBHelper db_helper;
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db_helper = DBHelper.getInstance(this);
        int count = db_helper.getFullContent(Constants.BOOK_TABLE,null);

        if(count == 0){
            insertBookData();
            Toast.makeText(this, "Data inserted Successfully for "+
                    db_helper.getFullContent(Constants.BOOK_TABLE,null)+ " rows",
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Data present for "+
                            db_helper.getFullContent(Constants.BOOK_TABLE,null)+ " rows",
                    Toast.LENGTH_SHORT).show();

            // Read the data and get the List OF BookData
            // Once you have got the list , on all book name , create a ListView
        }
    }

    private void insertBookData(){


        for (int i =0;i<book_name.length;i++){
            ContentValues cv = new ContentValues();
            cv.put(Constants.BOOK_ID,book_id[i]);
            cv.put(Constants.BOOK_NAME,book_name[i]);
            cv.put(Constants.BOOK_AUTHOR,book_author_name[i]);

            db_helper.insertContentValues(Constants.BOOK_TABLE,cv);

        }
    }
}
