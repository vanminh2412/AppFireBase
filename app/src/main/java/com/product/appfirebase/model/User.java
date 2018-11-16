package com.product.appfirebase.model;

public class User {
    String userID,userName,imageUser;

    public User() {
    }

    public User(String userID, String userName, String imageUser) {
        this.userID = userID;
        this.userName = userName;
        this.imageUser = imageUser;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getImageUser() {
        return imageUser;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setImageUser(String imageUser) {
        this.imageUser = imageUser;
    }
}
