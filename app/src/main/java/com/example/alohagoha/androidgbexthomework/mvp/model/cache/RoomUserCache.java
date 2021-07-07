package com.example.alohagoha.androidgbexthomework.mvp.model.cache;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.alohagoha.androidgbexthomework.mvp.model.entity.UserDTO;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.RoomUser;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.db.UserDatabase;

import io.reactivex.Single;

public class RoomUserCache implements ICache<UserDTO> {

    @Override
    public void write(final @Nullable UserDTO user) {
        RoomUser roomUser = getUserFromDB(user.getLogin());
        if (roomUser == null) {
            roomUser = new RoomUser();
            roomUser.setLogin(user.getLogin());
        }

        roomUser.setAvatarUrl(user.getAvatarUrl());
        roomUser.setReposUrl(user.getReposUrl());
        UserDatabase.getInstance().getUserDao().insert(roomUser);
    }

    @Override
    public Single<UserDTO> read(final @Nullable String username) {
        return Single
                .create(emitter -> {
                    RoomUser roomUser = getUserFromDB(username);
                    if (roomUser == null) {
                        emitter.onError(new RuntimeException("No such user in cache!"));
                    } else {
                        emitter.onSuccess(
                                new UserDTO(
                                        roomUser.getLogin(),
                                        roomUser.getAvatarUrl(),
                                        roomUser.getReposUrl())
                        );
                    }
                });
    }

    @Nullable
    private RoomUser getUserFromDB(final @NonNull String username) {
        return UserDatabase.getInstance()
                .getUserDao()
                .getUserByLogin(username);
    }
}
