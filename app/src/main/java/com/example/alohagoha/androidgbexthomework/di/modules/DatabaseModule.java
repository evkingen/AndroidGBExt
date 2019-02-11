package com.example.alohagoha.androidgbexthomework.di.modules;

import android.arch.persistence.room.Room;

import com.example.alohagoha.androidgbexthomework.App;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.db.UserDatabase;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    UserDatabase getUserDatabase(App context, @Named("nameDb") String nameDb) {
        return Room.databaseBuilder(context, UserDatabase.class, nameDb).build();
    }

    @Provides
    @Singleton
    @Named("nameDB")
    String getNameDb() {
        return "userdatabase.db";
    }
}
