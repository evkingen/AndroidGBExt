package com.example.alohagoha.androidgbexthomework.di.modules;

import android.widget.ImageView;

import com.example.alohagoha.androidgbexthomework.App;
import com.example.alohagoha.androidgbexthomework.mvp.model.cache.ICache;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.RoomImage;
import com.example.alohagoha.androidgbexthomework.mvp.model.image.IImageLoader;
import com.example.alohagoha.androidgbexthomework.ui.image.GlideImageLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ImageLoaderModule {

    @Provides
    @Singleton
    IImageLoader<ImageView> getGlideImageLoader(App app, ICache<RoomImage> cache) {
        return new GlideImageLoader(app, cache);
    }
}
