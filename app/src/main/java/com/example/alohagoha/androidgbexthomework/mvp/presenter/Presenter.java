package com.example.alohagoha.androidgbexthomework.mvp.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.alohagoha.androidgbexthomework.mvp.model.repo.RepositoriesRepo;
import com.example.alohagoha.androidgbexthomework.mvp.model.repo.UsersRepo;
import com.example.alohagoha.androidgbexthomework.mvp.presenter.list.IRepositoryListPresenter;
import com.example.alohagoha.androidgbexthomework.mvp.view.IMainView;
import com.example.alohagoha.androidgbexthomework.mvp.view.RepositoryItem.IRepositoryItemView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import timber.log.Timber;

@InjectViewState
public class Presenter extends MvpPresenter<IMainView> {
    Scheduler scheduler;
    UsersRepo usersRepo;
    RepositoriesRepo repositoriesRepo;
    private RepositoryListPresenter listPresenter;

    public Presenter(Scheduler scheduler) {
        this.scheduler = scheduler;
        usersRepo = new UsersRepo();
        repositoriesRepo = new RepositoriesRepo();
        listPresenter = new RepositoryListPresenter();
    }

    @SuppressLint("CheckResult")
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().initRecyclerView();
        loadUser();
        loadRepos();
    }

    @SuppressLint("CheckResult")
    private void loadUser() {
        usersRepo
                .getUser("evkingen")
                .observeOn(scheduler)
                .subscribe(userDTO -> {
                            getViewState().setImageUrl(userDTO.getAvatarUrl());
                            getViewState().setUsernameText(userDTO.getLogin());
                        },
                        Timber::e);

    }

    @SuppressLint("CheckResult")
    private void loadRepos() {
        repositoriesRepo
                .getRepos("evkingen")
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

        List<String> repos = new ArrayList<>();

        @Override
        public void bindView(IRepositoryItemView view) {
            String name = repos.get(view.getPos());
            view.setName(name);
        }

        @Override
        public int getRepositoriesCount() {
            return repos.size();
        }
    }
}
