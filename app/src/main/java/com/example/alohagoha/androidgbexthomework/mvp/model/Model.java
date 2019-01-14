package com.example.alohagoha.androidgbexthomework.mvp.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private final List<Integer> buttonClickCounters;

    public Model() {
        buttonClickCounters = new ArrayList<>();
        buttonClickCounters.add(0);
        buttonClickCounters.add(0);
        buttonClickCounters.add(0);
    }

    public Integer getValByIndex(int index) {
        return buttonClickCounters.get(index);
    }

    public void setValByIndex(int index, int value) {
        buttonClickCounters.set(index, value);
    }
}
