package com.example.alohagoha.androidgbexthomework;

import android.app.Application;

import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.db.UserDatabase;

import timber.log.Timber;

public class App extends Application {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Timber.plant(new Timber.DebugTree());
        UserDatabase.create(this);
    }


}
