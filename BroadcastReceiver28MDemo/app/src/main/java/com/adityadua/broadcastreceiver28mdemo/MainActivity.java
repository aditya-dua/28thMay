package com.adityadua.broadcastreceiver28mdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        openAlert();
        //super.onBackPressed();
    }

    private void openAlert(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setTitle("Exit App");
        alertDialogBuilder.setMessage("Are you sure you want to exit !");
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);

        alertDialogBuilder.setPositiveButton("Yes , Exit App", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Exiting....", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No, I will use the App", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "You may have presses back button by mistake , please continuw with your app", Toast.LENGTH_SHORT).show();

                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


    }

}
