package com.product.appfirebase.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.product.appfirebase.R;
import com.product.appfirebase.core.Common;
import com.product.appfirebase.model.News;
import com.product.appfirebase.model.Upload;
import com.product.appfirebase.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHoler> {
    private Context mContext;
    private List<News> mUploads;
    private OnItemClickListener mListener;
    public NewsAdapter(Context context, List<News> uploads) {
        mContext = context;
        mUploads = uploads;
    }
    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_view_news, parent, false);
        return new ViewHoler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler viewHoler, int position) {
        News uploadCurrent = mUploads.get(position);
        viewHoler.tv_content.setText(uploadCurrent.getmTextnew());
        Picasso.with(mContext)
                .load(uploadCurrent.getmImageNews())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(viewHoler.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }


    public class ViewHoler extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener{
        public TextView tv_content,tv_userName;
        public ImageView imageView;
        public ViewHoler(View itemView) {
            super(itemView);

            tv_userName = itemView.findViewById(R.id.tv_userName);
            tv_content = itemView.findViewById(R.id.tv_content);
            imageView = itemView.findViewById(R.id.imv_image);
            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(position);
                }
            }
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select Action");
            MenuItem doWhatever = menu.add(Menu.NONE, 1, 1, "Do whatever");
            MenuItem delete = menu.add(Menu.NONE, 2, 2, "Delete");

            doWhatever.setOnMenuItemClickListener(this);
            delete.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    switch (item.getItemId()) {
                        case 1:
                            mListener.onItemClick(position);
                            return true;
                        case 2:
                            mListener.onItemClick(position);
                            return true;
                    }
                }
            }
            return false;
        }

    }
    public interface OnItemClickListener {
        void onItemClick(int position);

        void onWhatEverClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = (OnItemClickListener) listener;
    }
}
