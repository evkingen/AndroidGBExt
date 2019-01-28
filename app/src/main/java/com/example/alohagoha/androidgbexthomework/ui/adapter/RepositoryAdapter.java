package com.example.alohagoha.androidgbexthomework.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alohagoha.androidgbexthomework.R;
import com.example.alohagoha.androidgbexthomework.mvp.presenter.list.IRepositoryListPresenter;
import com.example.alohagoha.androidgbexthomework.mvp.view.RepositoryItem.IRepositoryItemView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.ViewHolder> {
    private IRepositoryListPresenter presenter;

    public RepositoryAdapter(IRepositoryListPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.pos = position;
        presenter.bindView(holder);
    }

    @Override
    public int getItemCount() {
        return presenter.getRepositoriesCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements IRepositoryItemView {
        @BindView(R.id.tv_name)
        TextView nameTextView;

        int pos = 0;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public int getPos() {
            return pos;
        }

        @Override
        public void setName(String name) {
            nameTextView.setText(name);
        }

    }
}
