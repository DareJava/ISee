package com.iseeapp.isee.pojo;

import java.util.Date;

/**
 * Created by dare.fatimehin on 19/04/17.
 */

public class Comment {
    private String userAlias;
    private String message;
    private String howLongAgo;

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPostedTime() {
        return howLongAgo;
    }

    public void setPostedTime(String howLongAgo) {
        this.howLongAgo = howLongAgo;
    }
}
