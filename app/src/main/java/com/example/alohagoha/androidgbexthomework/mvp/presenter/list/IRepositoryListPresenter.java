package com.example.alohagoha.androidgbexthomework.mvp.presenter.list;

import com.example.alohagoha.androidgbexthomework.mvp.view.RepositoryItem.IRepositoryItemView;

public interface IRepositoryListPresenter {
    void bindView(IRepositoryItemView view);

    int getRepositoriesCount();
}
