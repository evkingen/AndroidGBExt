package com.example.alohagoha.androidgbexthomework.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.alohagoha.androidgbexthomework.mvp.model.Model;
import com.example.alohagoha.androidgbexthomework.mvp.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private Model model;

    public MainPresenter() {
        this.model = new Model();
    }

    public void onButtonClick(int index) {
        model.setValByIndex(index, model.getValByIndex(index) + 1);
        String buttonText = "Количество = " + model.getValByIndex(index);
        switch (index) {
            case 0:
                getViewState().setTextButtonClickOne(buttonText);
                break;
            case 1:
                getViewState().setTextButtonClickTwo(buttonText);
                break;
            case 2:
                getViewState().setTextButtonClickThree(buttonText);
                break;
        }
    }

}
