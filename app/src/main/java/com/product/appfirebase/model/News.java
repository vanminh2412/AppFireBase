package com.product.appfirebase.model;

public class News {
    String textnew,imageNews,newsId;

    public News() {
    }

    public News(String textnew, String imageNews, String newsId) {
        this.textnew = textnew;
        this.imageNews = imageNews;
        this.newsId = newsId;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getTextnew() {
        return textnew;
    }

    public void setTextnew(String textnew) {
        this.textnew = textnew;
    }

    public String getImageNews() {
        return imageNews;
    }

    public void setImageNews(String imageNews) {
        this.imageNews = imageNews;
    }
}
