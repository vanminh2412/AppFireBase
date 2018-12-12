package com.product.appfirebase.model;

import com.google.firebase.database.Exclude;

public class News {
    String mTextnew,mImageNews;
    private String mKey;
    public News() {
    }

    public News(String textnew, String imageNews) {
        if (textnew.trim().equals("")){
            textnew = "No Name";
        }
        mTextnew = textnew;
        mImageNews = imageNews;
    }



    public String getmTextnew() {
        return mTextnew;
    }

    public void setmTextnew(String mtextnew) {
        this.mTextnew = mtextnew;
    }

    public String getmImageNews() {
        return mImageNews;
    }

    public void setmImageNews(String mImageNews) {
        this.mImageNews = mImageNews;
    }

    @Exclude
    public String getKey() {
        return mKey;
    }

    @Exclude
    public void setKey(String key) {
        mKey = key;
    }
}
