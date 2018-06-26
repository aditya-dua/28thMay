package com.adityadua.notificationdemo28m;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simpleNotificationBtnClicked(View v){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("Test Notification Text")
                .setContentTitle("Title Notification");


        Intent i = new Intent(this,SecondActivity.class);

        PendingIntent pI = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pI);

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,builder.build());

    }

    public void bigTextNotificationButtonClicked(View v){
        Bitmap icon = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Big Text Notification")
                .setContentText("Big Text Notification - Text")
                .setLargeIcon(icon);


        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();

        bigTextStyle.bigText("The IndiGo Delhi-Kolkata flight (6E 786) was scheduled to depart at 3.20pm, which finally took off around 5pm.\n" +
                "“There was no air-conditioning inside the aircraft, and since we boarded in the afternoon with the scorching heat outside, sitting inside became increasingly suffocating,” said a passenger.");

        bigTextStyle.setBigContentTitle("Delhi Borne Flight makes People Wait");
        bigTextStyle.setSummaryText("By : Times Of India");

        mBuilder.setStyle(bigTextStyle);

        Intent i = new Intent(this,SecondActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntent(i);

        PendingIntent pi = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(pi);

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(100,mBuilder.build());


    }










}
