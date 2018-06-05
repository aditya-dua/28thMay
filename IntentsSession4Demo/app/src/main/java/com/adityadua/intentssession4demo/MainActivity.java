package com.adityadua.intentssession4demo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button loginBtn,resetBtn,contactSupportBtn,websiteBtn;
    EditText userEdt,pwdEdt;
    TextView registerTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = (Button)findViewById(R.id.loginbutton);
        resetBtn = (Button)findViewById(R.id.resetbutton);
        contactSupportBtn = (Button)findViewById(R.id.contactSupportBtn);
        websiteBtn = (Button)findViewById(R.id.websiteBtn);

        userEdt = (EditText)findViewById(R.id.userNameEditText);
        pwdEdt = (EditText)findViewById(R.id.PWDeditText);

        registerTV = (TextView)findViewById(R.id.registerLink);

        loginBtn.setOnClickListener(this);
        resetBtn.setOnClickListener(this);
        registerTV.setOnClickListener(this);
        contactSupportBtn.setOnClickListener(this);
        websiteBtn.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
       // View view : Points to the view which is clicked

       switch(view.getId()){
           case R.id.loginbutton : // we will do login

                                    String userName = userEdt.getText().toString();
                                    String pwd = pwdEdt.getText().toString();

                                    if(userName.equalsIgnoreCase("aditya") && pwd.equals("Aditya")){
                                        // we will code for Intent
                                        // Passing Data in Intents
                                        // Explict Intents
                                        Intent i = new Intent(MainActivity.this,LoginActivity.class);
                                        i.putExtra("username",userName);
                                        startActivity(i);
                                        
                                    }else{
                                        Toast.makeText(this, "Login Details are inCorrect !", Toast.LENGTH_SHORT).show();
                                    }
                                        break;

           case R.id.resetbutton : // reseet the textview over here

                                    userEdt.setText("");
                                    pwdEdt.setText("");

                                        break;

           case R.id.registerLink : // Take user to Registeration Page
                                    Toast.makeText(this, "You are being Redirected to Registeration Page", Toast.LENGTH_SHORT).show();

                                    Intent i = new Intent(MainActivity.this,RegisterationActivity.class);
                                    startActivity(i);

                                        break;

           case R.id.contactSupportBtn :
                                    // http : uri for web page
                                    // tel : uri for mobile number
                                    // http://www.google.com
                                    // tel:123456789
                                    String supportNumber ="123456789";
                                    Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+supportNumber));
                                    startActivity(dialIntent);

                                        break;
           case R.id.websiteBtn :
                                    Intent websiteIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.acadview.com"));
                                    startActivity(websiteIntent);

                                        break;


       }

    }
}
