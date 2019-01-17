package com.example.alohagoha.androidgbexthomework;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding3.widget.RxTextView;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.disposables.Disposable;


public class MainActivity extends AppCompatActivity {

    Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et = findViewById(R.id.et);
        final TextView tv = findViewById(R.id.tv);
        disposable = RxTextView.afterTextChangeEvents(et)
                .map(event -> event.getView().getText().toString())
                .subscribe(s -> tv.setText(s));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
