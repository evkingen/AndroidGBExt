package com.example.alohagoha.androidgbexthomework.mvp.model.repo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.alohagoha.androidgbexthomework.mvp.model.api.ApiHolder;
import com.example.alohagoha.androidgbexthomework.mvp.model.cache.ICache;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.UserDTO;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.RoomUser;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.db.UserDatabase;
import com.example.alohagoha.androidgbexthomework.ui.NetworkStatus;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class UsersRepo {

    private ICache<UserDTO> userCache;

    public UsersRepo(ICache<UserDTO> userCache) {
        this.userCache = userCache;
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
        return ApiHolder
                .getApi()
                .getUser(username)
                .doAfterSuccess(user -> userCache.write(user));
    }

    @NonNull
    private Single<UserDTO> getUserFromCache(final @NonNull String username) {
        return userCache.read(username);
    }

    @Nullable
    private RoomUser getUserFromDB(final @NonNull String username) {
        return UserDatabase
                .getInstance()
                .getUserDao()
                .getUserByLogin(username);
    }
}
