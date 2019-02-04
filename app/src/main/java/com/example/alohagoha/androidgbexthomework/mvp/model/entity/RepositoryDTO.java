package com.example.alohagoha.androidgbexthomework.mvp.model.entity;

import com.google.gson.annotations.Expose;

public class RepositoryDTO {
    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private OwnerDTO owner;

    public RepositoryDTO() {

    }

    public RepositoryDTO(String id, String name, OwnerDTO owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
