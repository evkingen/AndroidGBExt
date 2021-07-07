package com.example.alohagoha.androidgbexthomework.mvp.model.entity;

import com.google.gson.annotations.Expose;

public class OwnerDTO {
    @Expose
    private String login;

    public OwnerDTO() {

    }

    public OwnerDTO(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
