package com.example.alohagoha.androidgbexthomework.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.alohagoha.androidgbexthomework.R;
import com.example.alohagoha.androidgbexthomework.mvp.presenter.MainPresenter;
import com.example.alohagoha.androidgbexthomework.mvp.view.MainView;

public class MainActivity extends MvpAppCompatActivity implements View.OnClickListener, MainView {

    Button button1;
    Button button2;
    Button button3;

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_counter1:
                presenter.onButtonClick(0);
                break;
            case R.id.button_counter2:
                presenter.onButtonClick(1);
                break;
            case R.id.button_counter3:
                presenter.onButtonClick(2);
                break;
        }
    }

    @ProvidePresenter
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    public void init() {
        button1 = findViewById(R.id.button_counter1);
        button2 = findViewById(R.id.button_counter2);
        button3 = findViewById(R.id.button_counter3);
    }

    @Override
    public void setTextButtonClickOne(String text) {
        button1.setText(text);
    }

    @Override
    public void setTextButtonClickTwo(String text) {
        button2.setText(text);
    }

    @Override
    public void setTextButtonClickThree(String text) {
        button3.setText(text);
    }
}
