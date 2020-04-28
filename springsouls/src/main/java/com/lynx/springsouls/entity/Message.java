package com.lynx.springsouls.entity;

import java.util.Date;

public class Message {
    private int id;
    private int userid1;
    private int userid2;
    private String type;
    private int workid;
    private Date date;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWorkid() {
        return workid;
    }

    public void setWorkid(int workid) {
        this.workid = workid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
