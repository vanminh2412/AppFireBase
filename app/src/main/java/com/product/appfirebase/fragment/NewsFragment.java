package com.product.appfirebase.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.product.appfirebase.R;

public class NewsFragment extends Fragment {

    public NewsFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_news,container,false);

        return view;
    }
}
