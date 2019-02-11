package com.example.alohagoha.androidgbexthomework.di;

import com.example.alohagoha.androidgbexthomework.di.modules.ApiModule;
import com.example.alohagoha.androidgbexthomework.di.modules.AppModule;
import com.example.alohagoha.androidgbexthomework.di.modules.CacheModule;
import com.example.alohagoha.androidgbexthomework.di.modules.DatabaseModule;
import com.example.alohagoha.androidgbexthomework.di.modules.ImageLoaderModule;
import com.example.alohagoha.androidgbexthomework.di.modules.RepositoriesRepoModule;
import com.example.alohagoha.androidgbexthomework.di.modules.UsersRepoModule;
import com.example.alohagoha.androidgbexthomework.mvp.presenter.Presenter;
import com.example.alohagoha.androidgbexthomework.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        ApiModule.class,
        AppModule.class,
        CacheModule.class,
        UsersRepoModule.class,
        RepositoriesRepoModule.class,
        ImageLoaderModule.class,
        DatabaseModule.class
})
@Singleton
public interface AppComponent {
    void inject(Presenter mainPresenter);

    void inject(MainActivity activity);
}
