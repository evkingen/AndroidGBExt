package com.example.alohagoha.androidgbexthomework.mvp.model.cache;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.alohagoha.androidgbexthomework.mvp.model.entity.OwnerDTO;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.RepositoryDTO;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.RoomRepository;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.RoomUser;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.room.db.UserDatabase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class RoomRepositoriesCache implements ICache<List<RepositoryDTO>> {

    @Override
    public void write(List<RepositoryDTO> repositoryDTOS) {
        List<RoomRepository> roomRepositories = new ArrayList<>();
        for (RepositoryDTO repositoryDTO : repositoryDTOS) {
            roomRepositories.add(
                    new RoomRepository(
                            repositoryDTO.getId()
                            , repositoryDTO.getName()
                            , repositoryDTO.getOwner().getLogin()
                    )
            );
        }
        UserDatabase.getInstance()
                .getRepositoryDao()
                .insert(roomRepositories);
    }

    @Override
    public Single<List<RepositoryDTO>> read(String username) {
        return Single.create(emitter -> {
            RoomUser roomUser = getUserFromDB(username);
            if (roomUser == null) {
                emitter.onError(new RuntimeException("User not found in cache!"));
            }
            List<RoomRepository> roomRepositories = UserDatabase.getInstance()
                    .getRepositoryDao()
                    .findAllByUserLogin(username);
            List<RepositoryDTO> repos = new ArrayList<>();
            for (RoomRepository roomRepository : roomRepositories) {
                repos.add(new RepositoryDTO(
                                roomRepository.getId()
                                , roomRepository.getName()
                                , new OwnerDTO(username)
                        )
                );
            }
            emitter.onSuccess(repos);
        });
    }

    @Nullable
    private RoomUser getUserFromDB(final @NonNull String username) {
        return UserDatabase.getInstance()
                .getUserDao()
                .getUserByLogin(username);
    }
}
