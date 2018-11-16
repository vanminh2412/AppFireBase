package com.product.appfirebase.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHoler> {
    public NewsAdapter(){

    }
    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler viewHoler, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ViewHoler extends RecyclerView.ViewHolder{

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
        }
    }
}
