package com.example.alohagoha.androidgbexthomework.mvp.model.api;

import com.example.alohagoha.androidgbexthomework.mvp.model.entity.RepositoryDTO;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.UserDTO;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IDataSource {

    @GET("/users/{user}")
    Single<UserDTO> getUser(@Path("user") String username);

    @GET("/users/{user}/repos")
    Single<List<RepositoryDTO>> getRepos(@Path("user") String username);
}
