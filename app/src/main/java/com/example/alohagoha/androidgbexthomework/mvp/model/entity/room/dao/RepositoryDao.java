package com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.RoomRepository;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface RepositoryDao {

    @Insert(onConflict = REPLACE)
    void insert(RoomRepository repo);

    @Insert(onConflict = REPLACE)
    void insert(RoomRepository... repo);

    @Insert(onConflict = REPLACE)
    void insert(List<RoomRepository> repo);


    @Delete
    void delete(RoomRepository repo);

    @Delete
    void delete(RoomRepository... repo);

    @Delete
    void delete(List<RoomRepository> repo);


    @Update
    void update(RoomRepository repo);

    @Update
    void update(RoomRepository... repo);

    @Update
    void update(List<RoomRepository> repo);

    @Query("SELECT * FROM roomrepository")
    List<RoomRepository> getAll();

    @Query("SELECT * FROM roomrepository WHERE userLogin= :login")
    List<RoomRepository> findAllByUserLogin(String login);

}
