package com.example.alohagoha.androidgbexthomework.mvp.model.cache;

import io.reactivex.Single;

public interface ICache<T> {

    void write(T data);

    Single<T> read(String username);

}
