package com.lynx.springsouls.entity;

public class Report {
    private int id;
    private int reportid;
    private int userid;
    private int username;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReportid() {
        return reportid;
    }

    public void setReportid(int reportid) {
        this.reportid = reportid;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
