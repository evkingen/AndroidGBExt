package com.example.alohagoha.androidgbexthomework.mvp.model.entity;

import com.google.gson.annotations.Expose;

public class UserDTO {

    @Expose
    private String login;

    @Expose
    private String avatarUrl;

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
