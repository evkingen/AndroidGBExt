package com.example.alohagoha.androidgbexthomework.mvp.model.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHolder {
    private final static String BASE_URL = "https://api.github.com";
    private static ApiHolder instance = new ApiHolder();
    private IDataSource api;

    private ApiHolder() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(IDataSource.class);
    }

    public static ApiHolder getInstance() {
        if (instance == null) {
            instance = new ApiHolder();
        }
        return instance;
    }

    public static IDataSource getApi() {
        return instance.api;
    }
}
