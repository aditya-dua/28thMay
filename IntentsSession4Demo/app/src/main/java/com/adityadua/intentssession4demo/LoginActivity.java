package com.adityadua.intentssession4demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by AdityaDua on 04/06/18.
 */

public class LoginActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        Intent i = getIntent();
        String userName = i.getStringExtra("username");

        textView = (TextView)findViewById(R.id.userTV);
        textView.setText(textView.getText()+" "+userName+",");
    }
}
