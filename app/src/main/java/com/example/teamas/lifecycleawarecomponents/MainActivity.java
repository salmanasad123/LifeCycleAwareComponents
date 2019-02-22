package com.example.teamas.lifecycleawarecomponents;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    public static final String TAG = "MTAG";
    private MusicPlayer musicPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*musicPlayer = new MusicPlayer(this, getLifecycle());*/
        getLifecycle().addObserver(new MusicPlayer(this, getLifecycle()));

    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: Activity OnResume called");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "OnStart: Activity OnStart called");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: Activity OnStop called");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: Activity OnDestroy called");
        super.onDestroy();
    }
}
