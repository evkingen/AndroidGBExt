package com.example.alohagoha.androidgbexthomework.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.alohagoha.androidgbexthomework.R;
import com.example.alohagoha.androidgbexthomework.mvp.model.image.IImageLoader;
import com.example.alohagoha.androidgbexthomework.mvp.presenter.Presenter;
import com.example.alohagoha.androidgbexthomework.mvp.view.IMainView;
import com.example.alohagoha.androidgbexthomework.ui.adapter.RepositoryAdapter;
import com.example.alohagoha.androidgbexthomework.ui.image.GlideImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends MvpAppCompatActivity implements IMainView {
    private final IImageLoader<ImageView> imageLoader = new GlideImageLoader();
    @InjectPresenter
    Presenter presenter;
    RepositoryAdapter adapter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tv_username)
    TextView usernameTextView;
    @BindView(R.id.iv_avatar)
    ImageView avatarImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @ProvidePresenter
    public Presenter providePresenter() {
        return new Presenter(AndroidSchedulers.mainThread());
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setImageUrl(String url) {
        imageLoader.loadInto(url, avatarImageView);
    }

    @Override
    public void setUsernameText(String text) {
        usernameTextView.setText(text);
    }

    @Override
    public void updateRecyclerView() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new RepositoryAdapter(presenter.getListPresenter());
        recyclerView.setAdapter(adapter);
    }
}
