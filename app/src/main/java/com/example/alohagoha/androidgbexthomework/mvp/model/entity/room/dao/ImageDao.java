package com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.RoomImage;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ImageDao {
    @Insert(onConflict = REPLACE)
    void insert(RoomImage image);

    @Insert(onConflict = REPLACE)
    void insert(RoomImage... image);

    @Insert(onConflict = REPLACE)
    void insert(List<RoomImage> image);


    @Delete
    void delete(RoomImage image);

    @Delete
    void delete(RoomImage... image);

    @Delete
    void delete(List<RoomImage> image);


    @Update
    void update(RoomImage image);

    @Update
    void update(RoomImage... image);

    @Update
    void update(List<RoomImage> image);


    @Query("SELECT * FROM roomimage")
    List<RoomImage> getAll();

    @Query("SELECT * FROM roomimage WHERE url= :url LIMIT 1")
    RoomImage getImageByUrl(String url);
}

