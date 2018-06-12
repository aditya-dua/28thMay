package com.adityadua.filestorage28mdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by AdityaDua on 10/06/18.
 */

public class ExternalStorageActivity extends AppCompatActivity implements View.OnClickListener{


    Button readBtn,saveBtn;
    EditText text;
    TextView textShow;
    String FILENAME = "myExternalFile.txt";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.external_resouce);


        readBtn = (Button)findViewById(R.id.ESFetchBtn);
        saveBtn = (Button)findViewById(R.id.ESSaveBTN);

        text = (EditText)findViewById(R.id.textET);

        textShow = (TextView)findViewById(R.id.readText);

        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File(Environment.getExternalStorageDirectory()+"/"+FILENAME);
                String aRow="";
                String textfinal="";


                try {
                    FileInputStream fin = new FileInputStream(file);

                    BufferedReader bRwader = new BufferedReader(new InputStreamReader(fin));


                    while((aRow = bRwader.readLine()) !=null){
                        textfinal = textfinal+aRow;

                    }


                    textShow.setText(textfinal);
                    bRwader.close();

                    Toast.makeText(getApplicationContext(), "File has been read", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        saveBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        Toast.makeText(this, "On CLick called", Toast.LENGTH_SHORT).show();

        if(view.getId() == R.id.ESFetchBtn){

            File file = new File(Environment.getExternalStorageDirectory()+"/"+FILENAME);
            String aRow="";
            String textfinal="";


            try {
                FileInputStream fin = new FileInputStream(file);

                BufferedReader bRwader = new BufferedReader(new InputStreamReader(fin));


                while((aRow = bRwader.readLine()) !=null){
                textfinal = textfinal+aRow;

                }


                textShow.setText(textfinal);
                bRwader.close();

                Toast.makeText(this, "File has been read", Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (view.getId() == R.id.ESSaveBTN){
            try {
                File f = new File(Environment.getExternalStorageDirectory()+"/"+FILENAME);

                f.createNewFile();

                FileOutputStream fileOutputStream = new FileOutputStream(f);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                outputStreamWriter.append(text.getText().toString());

                outputStreamWriter.close();
                fileOutputStream.close();


                Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
