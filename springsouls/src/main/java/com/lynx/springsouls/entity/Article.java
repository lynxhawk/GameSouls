package com.lynx.springsouls.entity;

import java.util.Date;

public class Article {
    private int id;
    private int userid;
    private int username;
    private Date date;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    public int getCollect() {
        return collect;
    }

    public void setCollect(int collect) {
        this.collect = collect;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    private String subtitle;
    private String text;
    private String cover;
    private int heart;
    private int collect;
    private int comment;


}
