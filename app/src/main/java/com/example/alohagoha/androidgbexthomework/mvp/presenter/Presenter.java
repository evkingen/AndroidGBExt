package com.example.alohagoha.androidgbexthomework.mvp.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.RepositoryDTO;
import com.example.alohagoha.androidgbexthomework.mvp.model.entity.UserDTO;
import com.example.alohagoha.androidgbexthomework.mvp.model.repo.RepositoriesRepo;
import com.example.alohagoha.androidgbexthomework.mvp.model.repo.UsersRepo;
import com.example.alohagoha.androidgbexthomework.mvp.presenter.list.IRepositoryListPresenter;
import com.example.alohagoha.androidgbexthomework.mvp.view.IMainView;
import com.example.alohagoha.androidgbexthomework.mvp.view.RepositoryItem.IRepositoryItemView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import timber.log.Timber;

@InjectViewState
public class Presenter extends MvpPresenter<IMainView> {
    Scheduler scheduler;
    @Inject
    UsersRepo usersRepo;
    @Inject
    RepositoriesRepo repositoriesRepo;
    UserDTO user;
    private RepositoryListPresenter listPresenter;

    public Presenter(Scheduler scheduler) {
        this.scheduler = scheduler;
        listPresenter = new RepositoryListPresenter();
    }

    @SuppressLint("CheckResult")
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().initRecyclerView();
        loadInfo("googlesamples");
    }

    @SuppressLint("CheckResult")
    private void loadInfo(String username) {
        usersRepo
                .getUser(username)
                .observeOn(scheduler)
                .subscribe(userDTO -> {
                            this.user = userDTO;
                            getViewState().setImageUrl(userDTO.getAvatarUrl());
                            getViewState().setUsernameText(userDTO.getLogin());
                            loadRepos(userDTO);
                        },
                        Timber::e);

    }

    @SuppressLint("CheckResult")
    private void loadRepos(UserDTO user) {
        repositoriesRepo
                .getRepos(user)
                .observeOn(scheduler)
                .subscribe(repositoryDTO -> {
                            listPresenter.repos = repositoryDTO;
                            getViewState().updateRecyclerView();
                        },
                        Timber::e);
    }

    public RepositoryListPresenter getListPresenter() {
        return listPresenter;
    }

    public class RepositoryListPresenter implements IRepositoryListPresenter {

        List<RepositoryDTO> repos = new ArrayList<>();

        @Override
        public void bindView(IRepositoryItemView view) {
            RepositoryDTO repository = repos.get(view.getPos());
            view.setName(repository.getName());
        }

        @Override
        public int getRepositoriesCount() {
            return repos.size();
        }
    }
}
