package com.example.alohagoha.androidgbexthomework.mvp.model.entity;

import com.google.gson.annotations.Expose;

public class RepositoryDTO {
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
