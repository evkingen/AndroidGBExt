package com.example.alohagoha.androidgbexthomework.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface IMainView extends MvpView {
    void showMessage(String text);

    void setImageUrl(String url);

    void setUsernameText(String text);

    void updateRecyclerView();

    void initRecyclerView();
}
