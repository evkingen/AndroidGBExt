package com.example.alohagoha.androidgbexthomework.mvp.model.repo;

import com.example.alohagoha.androidgbexthomework.mvp.model.api.ApiHolder;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.UserDTO;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class UsersRepo {
    public Single<UserDTO> getUser(String username) {
        return ApiHolder.getApi().getUser(username).subscribeOn(Schedulers.io());
    }
}
