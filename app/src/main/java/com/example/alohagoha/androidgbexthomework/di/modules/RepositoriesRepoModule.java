package com.example.alohagoha.androidgbexthomework.di.modules;

import com.example.alohagoha.androidgbexthomework.mvp.model.api.IDataSource;
import com.example.alohagoha.androidgbexthomework.mvp.model.cache.ICache;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.RepositoryDTO;
import com.example.alohagoha.androidgbexthomework.mvp.model.repo.RepositoriesRepo;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesRepoModule {
    @Provides
    @Singleton
    RepositoriesRepo getRepository(ICache<List<RepositoryDTO>> cache, IDataSource api) {
        return new RepositoriesRepo(cache, api);
    }
}
