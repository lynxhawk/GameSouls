package com.lynx.springsouls.entity;

public class Follow {
    private int id;
    private int userid;
    private String useravatar;
    private String usertext;
    private int followid;
    private String followavatar;
    private String followtext;

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

    public String getUseravatar() {
        return useravatar;
    }

    public void setUseravatar(String useravatar) {
        this.useravatar = useravatar;
    }

    public String getUsertext() {
        return usertext;
    }

    public void setUsertext(String usertext) {
        this.usertext = usertext;
    }

    public int getFollowid() {
        return followid;
    }

    public void setFollowid(int followid) {
        this.followid = followid;
    }

    public String getFollowavatar() {
        return followavatar;
    }

    public void setFollowavatar(String followavatar) {
        this.followavatar = followavatar;
    }

    public String getFollowtext() {
        return followtext;
    }

    public void setFollowtext(String followtext) {
        this.followtext = followtext;
    }
}
