package com.adityadua.broadcastreceiver28mdemo;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by AdityaDua on 20/06/18.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String action= intent.getAction();

        Toast.makeText(context, "In onReceive Broadcast for "+action, Toast.LENGTH_SHORT).show();

        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(context.getApplicationContext())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Date & Time Changed")
                .setContentText("Seems you have changed your homeplace , let me show whats near")
                .setAutoCancel(true);

        NotificationManager nm = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(100,mBuilder.build());
    }
}
