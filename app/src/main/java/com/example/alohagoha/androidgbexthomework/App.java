package com.example.alohagoha.androidgbexthomework;

import android.app.Application;

import com.example.alohagoha.androidgbexthomework.di.AppComponent;
import com.example.alohagoha.androidgbexthomework.di.DaggerAppComponent;
import com.example.alohagoha.androidgbexthomework.di.modules.AppModule;

import timber.log.Timber;

public class App extends Application {

    private static App instance;

    private AppComponent appComponent;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Timber.plant(new Timber.DebugTree());
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getComponent() {
        return appComponent;
    }
}
