package com.example.alohagoha.androidgbexthomework.di.modules;

import com.example.alohagoha.androidgbexthomework.mvp.model.api.IDataSource;
import com.example.alohagoha.androidgbexthomework.mvp.model.cache.ICache;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.UserDTO;
import com.example.alohagoha.androidgbexthomework.mvp.model.repo.UsersRepo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UsersRepoModule {
    @Provides
    @Singleton
    UsersRepo getUsersRepo(ICache<UserDTO> cache, IDataSource api) {
        return new UsersRepo(cache, api);
    }
}
