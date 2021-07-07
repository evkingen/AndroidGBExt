package com.example.alohagoha.androidgbexthomework.mvp.model.image;

public interface IImageLoader<T> {

    void loadInto(String url, T container);

}
