package com.example.alohagoha.androidgbexthomework.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface MainView extends MvpView {

    void setTextButtonClickOne(String text);

    void setTextButtonClickTwo(String text);

    void setTextButtonClickThree(String text);

}
