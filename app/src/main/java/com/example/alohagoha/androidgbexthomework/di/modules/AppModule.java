package com.example.alohagoha.androidgbexthomework.di.modules;

import com.example.alohagoha.androidgbexthomework.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public App getApp() {
        return app;
    }
}
