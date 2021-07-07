package com.example.alohagoha.androidgbexthomework.mvp.model.entity;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    @Expose
    private String login;

    @Expose
    private String avatarUrl;

    @Expose
    private String reposUrl;

    private List<RepositoryDTO> repos = new ArrayList<>();

    public UserDTO() {

    }

    public UserDTO(String login, String avatarUrl, String reposUrl) {
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.reposUrl = reposUrl;
    }

    public List<RepositoryDTO> getRepos() {
        return repos;
    }

    public void setRepos(List<RepositoryDTO> repos) {
        this.repos = repos;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
