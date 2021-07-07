package com.example.alohagoha.androidgbexthomework.mvp.model.entity.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class RoomImage {

    @NonNull
    @PrimaryKey
    private String url;
    private String filePath;

    public RoomImage() {

    }

    public RoomImage(String url, String filePath) {
        this.url = url;
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @NonNull
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
