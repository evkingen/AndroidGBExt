package com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.RoomUser;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {

    @Insert(onConflict = REPLACE)
    void insert(RoomUser user);

    @Insert(onConflict = REPLACE)
    void insert(RoomUser... user);

    @Insert(onConflict = REPLACE)
    void insert(List<RoomUser> user);


    @Delete
    void delete(RoomUser user);

    @Delete
    void delete(RoomUser... user);

    @Delete
    void delete(List<RoomUser> user);


    @Update
    void update(RoomUser user);

    @Update
    void update(RoomUser... user);

    @Update
    void update(List<RoomUser> user);


    @Query("SELECT * FROM roomuser")
    List<RoomUser> getAll();

    @Query("SELECT * FROM roomuser WHERE login= :login LIMIT 1")
    RoomUser getUserByLogin(String login);
}
