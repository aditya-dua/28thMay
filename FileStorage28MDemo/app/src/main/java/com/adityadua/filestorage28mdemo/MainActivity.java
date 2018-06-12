package com.adityadua.filestorage28mdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    EditText textEditText;
    Button saveBtn, fetchBtn;
    TextView fetchTV;
    String FILENAME = "myFile.txt";
    Button nextPAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textEditText = (EditText)findViewById(R.id.editText);
        saveBtn = (Button)findViewById(R.id.savebutton);
        fetchBtn = (Button)findViewById(R.id.fetchbutton2);
        fetchTV= (TextView)findViewById(R.id.fetchTV);

        saveBtn.setOnClickListener(this);
        fetchBtn.setOnClickListener(this);

        nextPAge = (Button)findViewById(R.id.NextPageBtn);
        nextPAge.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.savebutton){

            // Save Data To File
            try {
                FileOutputStream fileOutputStream = openFileOutput(FILENAME,MODE_PRIVATE);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                outputStreamWriter.write(textEditText.getText().toString());


                outputStreamWriter.close();
                Toast.makeText(this, "File Saved Successfully", Toast.LENGTH_SHORT).show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if(view.getId() == R.id.fetchbutton2){

            try {
                FileInputStream fileInputStream = openFileInput(FILENAME);

                InputStreamReader inputReader = new InputStreamReader(fileInputStream);

                char [] inputText = new char[100];
                String finalFileText = "";

                int charCount;

                // using inputreader , read from file
                // maximu size kiska : array : 100
                // charCount
                // charCount == 0
                while ((charCount = inputReader.read(inputText))>0){
                    finalFileText = finalFileText + String.copyValueOf(inputText);
                }
                inputReader.close();
                fetchTV.setText(finalFileText);
                fetchTV.setVisibility(TextView.VISIBLE);

                Toast.makeText(this, "File Read , see the TV", Toast.LENGTH_SHORT).show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if(view.getId() == R.id.NextPageBtn){
            Intent i = new Intent(MainActivity.this,ExternalStorageActivity.class);
            startActivity(i);
        }





    }
}
