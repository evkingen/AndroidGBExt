package com.example.alohagoha.androidgbexthomework.mvp.model.repo;

import com.example.alohagoha.androidgbexthomework.mvp.model.api.ApiHolder;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class RepositoriesRepo {

    public Single<List<String>> getRepos(String username) {
        return ApiHolder
                .getApi()
                .getRepos(username)
                .map(repositoryDTOS -> {
                    List<String> names = new ArrayList<>();
                    for (int i = 0; i < repositoryDTOS.size(); i++) {
                        names.add(repositoryDTOS.get(i).getName());
                    }
                    return names;
                }).subscribeOn(Schedulers.io());
    }
}
