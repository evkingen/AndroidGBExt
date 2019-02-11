package com.example.alohagoha.androidgbexthomework.di.modules;

import com.example.alohagoha.androidgbexthomework.mvp.model.cache.ICache;
import com.example.alohagoha.androidgbexthomework.mvp.model.cache.RoomImageCache;
import com.example.alohagoha.androidgbexthomework.mvp.model.cache.RoomRepositoriesCache;
import com.example.alohagoha.androidgbexthomework.mvp.model.cache.RoomUserCache;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.RepositoryDTO;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.UserDTO;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.RoomImage;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.db.UserDatabase;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class CacheModule {
    @Provides
    ICache<UserDTO> getUserCache(UserDatabase db) {
        return new RoomUserCache(db);
    }

    @Provides
    ICache<List<RepositoryDTO>> getRepositoryCache(UserDatabase db) {
        return new RoomRepositoriesCache(db);
    }

    @Provides
    ICache<RoomImage> getImageCache(UserDatabase db) {
        return new RoomImageCache(db);
    }
}
