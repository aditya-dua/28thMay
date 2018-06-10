package com.adityadua.sharedprefs28mdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userNameET,passwordET,pinET;
    Button signUpBtn;
    SharedPreferences sharedPreferences;
    String UKEY="username",PKEY="password",PINKEY="pin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameET= (EditText)findViewById(R.id.editText);
        passwordET = (EditText)findViewById(R.id.editText2);
        pinET = (EditText)findViewById(R.id.editText4);

        signUpBtn = (Button)findViewById(R.id.button);

        sharedPreferences = getSharedPreferences("mysharedPrefs", Context.MODE_PRIVATE);

        if(sharedPreferences.contains(UKEY) && sharedPreferences.contains(PKEY)
                && sharedPreferences.contains(PINKEY)){
            // where he wil enter the pin and continue

            Intent i = new Intent(MainActivity.this,PINActivity.class);
            startActivity(i);
        }else {

        }
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uName = userNameET.getText().toString();
                String pwd = passwordET.getText().toString();
                String pin = pinET.getText().toString();

                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString(UKEY,uName);
                editor.putString(PKEY,pwd);
                editor.putString(PINKEY,pin);
                editor.commit();
                Toast.makeText(MainActivity.this, "Login details saved", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
