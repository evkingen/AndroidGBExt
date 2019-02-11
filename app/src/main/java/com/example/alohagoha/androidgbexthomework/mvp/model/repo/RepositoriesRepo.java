package com.example.alohagoha.androidgbexthomework.mvp.model.repo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.alohagoha.androidgbexthomework.mvp.model.api.IDataSource;
import com.example.alohagoha.androidgbexthomework.mvp.model.cache.ICache;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.RepositoryDTO;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.UserDTO;
import com.example.alohagoha.androidgbexthomework.ui.NetworkStatus;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class RepositoriesRepo {

    private ICache<List<RepositoryDTO>> cache;
    private IDataSource api;

    public RepositoriesRepo(ICache cache, IDataSource api) {
        this.cache = cache;
        this.api = api;
    }

    @NonNull
    public Single<List<RepositoryDTO>> getRepos(final @Nullable UserDTO user) {
        final Single<List<RepositoryDTO>> repos;

        if (NetworkStatus.isOnline()) {
            repos = getReposFromNetwork(user);
        } else {
            repos = getReposFromCache(user.getLogin());
        }
        return repos.subscribeOn(Schedulers.io());
    }

    @NonNull
    private Single<List<RepositoryDTO>> getReposFromNetwork(final @Nullable UserDTO user) {
        return api
                .getRepos(user.getLogin())
                .doAfterSuccess(repositoryDTOS -> cache.write(repositoryDTOS));
    }

    @NonNull
    private Single<List<RepositoryDTO>> getReposFromCache(final @Nullable String username) {
        return cache.read(username);
    }


}
