package com.example.alohagoha.androidgbexthomework.mvp.model.repo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.alohagoha.androidgbexthomework.mvp.model.api.IDataSource;
import com.example.alohagoha.androidgbexthomework.mvp.model.cache.ICache;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.UserDTO;
import com.example.alohagoha.androidgbexthomework.ui.NetworkStatus;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class UsersRepo {

    private ICache<UserDTO> userCache;
    private IDataSource api;

    public UsersRepo(ICache<UserDTO> userCache, IDataSource api) {
        this.userCache = userCache;
        this.api = api;
    }


    public ICache<UserDTO> getUserCache() {
        return userCache;
    }

    @NonNull
    public Single<UserDTO> getUser(final @Nullable String username) {
        final Single<UserDTO> user;

        if (NetworkStatus.isOnline()) {
            user = getUserFromNetwork(username);
        } else {
            user = getUserFromCache(username);
        }
        return user.subscribeOn(Schedulers.io());
    }

    @NonNull
    private Single<UserDTO> getUserFromNetwork(final @NonNull String username) {
        return api
                .getUser(username)
                .doAfterSuccess(user -> userCache.write(user));
    }

    @NonNull
    private Single<UserDTO> getUserFromCache(final @NonNull String username) {
        return userCache.read(username);
    }

}
