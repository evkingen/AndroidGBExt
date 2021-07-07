package com.example.alohagoha.androidgbexthomework.mvp.model.cache;

import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.RoomImage;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.db.UserDatabase;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RoomImageCache implements ICache<RoomImage> {

    @Override
    public void write(RoomImage data) {
        Disposable disposable = Completable.fromAction(() ->
                UserDatabase.getInstance().getImageDao().insert(data)).subscribeOn(Schedulers.io()).subscribe();
    }

    @Override
    public Single<RoomImage> read(String url) {
        return Single.create(emitter -> {
            RoomImage roomImage = UserDatabase.getInstance().getImageDao().getImageByUrl(url);
            if (roomImage == null) {
                emitter.onError(new RuntimeException("Not found image!"));
            } else {
                emitter.onSuccess(roomImage);
            }
        });
    }
}
