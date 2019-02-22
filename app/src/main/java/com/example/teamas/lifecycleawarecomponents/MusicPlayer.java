package com.example.teamas.lifecycleawarecomponents;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

public class MusicPlayer implements LifecycleObserver {
    public static final String TAG = "MTAG";
    private Context context;
    private Lifecycle lifecycle;
    private MediaPlayer mediaPlayer;
    private int length = -1;

    public MusicPlayer(MainActivity mainActivity, Lifecycle lifecycle) {
        context = mainActivity;
        this.lifecycle = lifecycle;
        /* registerObserver(lifecycle);*/
    }

    private void registerObserver(Lifecycle lifecycle) {
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void initializeMusicPlayer() {
        Log.d(TAG, "initializeMusicPlayer: Activity OnStart Received");
        Log.d(TAG, "initializeMusicPlayer: Music Player Initialized");
        mediaPlayer = MediaPlayer.create(context.getApplicationContext(), R.raw.wajahtumho);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void startMusicPlayer() {
        Log.d(TAG, "startMusicPlayer: Activity OnResume Received");
        Log.d(TAG, "startMusicPlayer: Music Player Started");

        if (length == -1) {
            mediaPlayer.start();

        } else {
            mediaPlayer.seekTo(length);
            mediaPlayer.start();
        }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void pauseMusicPlayer() {
        Log.d(TAG, "pauseMusicPlayer: Activity OnPause Received");
        Log.d(TAG, "pauseMusicPlayer: Music Player Paused");
        mediaPlayer.pause();
        length = mediaPlayer.getCurrentPosition();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stopMusicPlayer() {
        Log.d(TAG, "stopMusicPlayer: Activity OnStop Received");
        Log.d(TAG, "stopMusicPlayer: Music Player Stopped");
        mediaPlayer.stop();
    }


}
