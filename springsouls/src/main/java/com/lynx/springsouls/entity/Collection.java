package com.lynx.springsouls.entity;

public class Collection {
    private int id;
    private int userid1;
    private int userid2;
    private String avatar;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid1() {
        return userid1;
    }

    public void setUserid1(int userid1) {
        this.userid1 = userid1;
    }

    public int getUserid2() {
        return userid2;
    }

    public void setUserid2(int userid2) {
        this.userid2 = userid2;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
