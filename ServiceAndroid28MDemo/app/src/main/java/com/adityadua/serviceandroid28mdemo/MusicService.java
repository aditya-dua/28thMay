package com.adityadua.serviceandroid28mdemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by AdityaDua on 19/06/18.
 */

public class MusicService extends Service {

    MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(getApplicationContext(),R.raw.jean2);

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        mp.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mp.isPlaying()){
            mp.stop();
        }
    }
}
